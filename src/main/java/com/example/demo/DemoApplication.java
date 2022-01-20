package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	private String ffmpegExe;

	public DemoApplication(String ffmpegExe) {
		this.ffmpegExe = ffmpegExe;
	}

	public void convertor(String videoInputPath, String videoOutputPath) throws Exception
	{
		//ffmpeg -i inputpath outputPath to run commmands
		List<String> commandList = new ArrayList<>();
		commandList.add(ffmpegExe);
		commandList.add("-i");
		commandList.add(videoInputPath);
		commandList.add(videoOutputPath);

		ProcessBuilder process = new ProcessBuilder(commandList);
		process.start();
	}

	public static void main(String[] args) throws Exception {
		DemoApplication  ffmpeg = new DemoApplication("C:\\ffmpeg\\bin\\ffmpeg.exe");
		try {
			ffmpeg.convertor("C:\\inder.mp4", "D:\\inder1.avi");
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
		SpringApplication.run(DemoApplication.class, args);
	}
}
