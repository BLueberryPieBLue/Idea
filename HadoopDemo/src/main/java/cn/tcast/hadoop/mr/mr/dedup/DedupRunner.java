package cn.tcast.hadoop.mr.mr.dedup;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class DedupRunner {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);

		job.setJarByClass(DedupRunner.class);

		job.setMapperClass(DedupMapper.class);
		job.setReducerClass(DedupReducer.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(NullWritable.class);

		FileInputFormat.setInputPaths(job, new Path("E:\\Idea\\Dedup\\{input/*}"));
		// 指定处理完成之后的结果所保存的位置
		FileOutputFormat.setOutputPath(job, new Path("E:\\Idea\\Dedup\\output"));

		job.waitForCompletion(true);

	}
}
