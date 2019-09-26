package cn.tcast.hadoop.mr.hadoop.mr;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		// 拿到传入进来的一行内容，把数据类型转换为String
		String line = value.toString();
		// 将这行内容按照分隔符切割
		String[] words = line.split(" ");
		// 遍历数组，每出现一个单词就标记一个数组1 例如：<单词,1>
		for (String word : words) {
			// 使用MR上下文context，把Map阶段处理的数据发送给Reduce阶段作为输入数据
			context.write(new Text(word), new IntWritable(1));
			//第一行 hadoop hadoop spark  发送出去的是<hadoop,1><hadoop,1><spark,1> 
		}
	}
}
