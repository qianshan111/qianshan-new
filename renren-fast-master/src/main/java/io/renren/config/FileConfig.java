package io.renren.config;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * @author zhoujian
 * @date 2023/3/12 16:48
 */
public class FileConfig {
  /**
   * 当前项目目录下的files
   */
  public static String  FILE_ADDRESS_PATH =  System.getProperty("user.dir") + "\\files\\";

  /**
   * 将图片转为字符串
   */
  public static String imgGenerateString(String filename) throws IOException {
    File file = new File(FILE_ADDRESS_PATH + "\\" + filename);
    InputStream inputStream = new FileInputStream(file) ;
    byte[] bytes = new byte[inputStream.available()];
    StringBuffer stringBuffer = new StringBuffer();
    inputStream.read(bytes);
    inputStream.close();
    BASE64Encoder encoder = new BASE64Encoder();
    String imageStr = encoder.encode(bytes);
    return imageStr;
  }

  /**
   * 将字符串转换为图片
   */
  public static void stringGenerateImg(String imageStr,String filename){
    File dir = new File(FILE_ADDRESS_PATH);
    if(!dir.exists()){
      dir.mkdirs();
    }
    File file = new File(FILE_ADDRESS_PATH+filename);
    if(file.exists()){
      return;
    }
    BASE64Decoder decoder = new BASE64Decoder();
    try{
      byte[] b = decoder.decodeBuffer(imageStr);
      for (int i = 0; i < b.length; i++) {
        if(b[i]<0){
          b[i]+=256;
        }
      }
      OutputStream outputStream = new FileOutputStream(FILE_ADDRESS_PATH+"\\"+filename);
      outputStream.write(b);
      outputStream.flush();
      outputStream.close();
    } catch (Exception e){
      e.printStackTrace();
    }
  }
}
