package cn.tcast.hadoop.mr.mr.topn;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class TopNRunner {
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();

		Job job = Job.getInstance(conf);

		job.setJarByClass(TopNRunner.class);
		job.setMapperClass(TopNMapper.class);
		job.setReducerClass(TopNReducer.class);

		job.setNumReduceTasks(1);

		job.setMapOutputKeyClass(NullWritable.class);// map阶段的输出的key
		job.setMapOutputValueClass(IntWritable.class);// map阶段的输出的value

		job.setOutputKeyClass(NullWritable.class);// reduce阶段的输出的key
		job.setOutputValueClass(IntWritable.class);// reduce阶段的输出的value

		FileInputFormat.setInputPaths(job, new Path("E:\\Idea\\topN\\{input/*}"));
		FileOutputFormat.setOutputPath(job, new Path("E:\\Idea\\topN\\output"));

		boolean res = job.waitForCompletion(true);
		System.exit(res ? 0 : 1);
	}
}
