package yq;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

import org.apache.commons.math3.geometry.euclidean.threed.Plane;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Demo {
	// 柱状图生成
	static ChartPanel frame1;
	static int x, y, n;

	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.run();

	}

	public void run() {
		// 主界面
		JFrame frame = new JFrame("西北师范大学疫情上报系统");
		JPanel panel1 = new JPanel();
		// panel1.setLayout(new GridLayout(3, 1));
		panel1.setLayout(null);
		frame.add(panel1);
		frame.setBounds(10, 10, 500, 350);
		Button button1 = new Button("疫情信息上报");
		button1.setBounds(175, 50, 150, 30);
		button1.setVisible(false);
		panel1.add(button1);
		Button button0 = new Button("疫情信息上报");
		button0.setBounds(175, 50, 150, 30);
		button0.setVisible(false);
		panel1.add(button0);
		Button button2 = new Button("二级部门负责人入口");
		button2.setBounds(175, 130, 150, 30);
		button2.setVisible(false);
		panel1.add(button2);
		Button button3 = new Button("防控办负责人入口");
		button3.setBounds(175, 210, 150, 30);
		button3.setVisible(false);
		panel1.add(button3);

		Image image = new ImageIcon("school.jpg").getImage();
		image = image.getScaledInstance(400, 100, 0);
		JLabel lab1 = new JLabel(new ImageIcon(image));
		lab1.setBounds(50, 0, 400, 100);
		panel1.add(lab1);

		JLabel lab2 = new JLabel("身份：", Label.LEFT);
		lab2.setBounds(100, 110, 150, 30);
		JTextField jt1 = new JTextField();
		jt1.setBounds(250, 110, 150, 30);
		JLabel lab3 = new JLabel("密码：", Label.LEFT);
		lab3.setBounds(100, 150, 150, 30);
		JPasswordField jp1 = new JPasswordField();
		jp1.setBounds(250, 150, 150, 30);
		JButton b = new JButton("登入");
		b.setBounds(200, 190, 100, 30);
		panel1.add(lab2);
		panel1.add(jt1);
		panel1.add(lab3);
		panel1.add(jp1);
		panel1.add(b);
		frame.setVisible(true);

		// 登入界面
		b.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (jt1.getText().equals("学生") && jp1.getText().equals("123")) {
					lab1.setVisible(false);
					lab2.setVisible(false);
					jt1.setVisible(false);
					lab3.setVisible(false);
					jp1.setVisible(false);
					b.setVisible(false);
					button1.setVisible(true);
				}
				else if (jt1.getText().equals("老师") && jp1.getText().equals("123")) {
					lab1.setVisible(false);
					lab2.setVisible(false);
					jt1.setVisible(false);
					lab3.setVisible(false);
					jp1.setVisible(false);
					b.setVisible(false);
					button1.setVisible(true);
				}
				else if (jt1.getText().equals("二级部门") && jp1.getText().equals("123")) {
					lab1.setVisible(false);
					lab2.setVisible(false);
					jt1.setVisible(false);
					lab3.setVisible(false);
					jp1.setVisible(false);
					b.setVisible(false);
					button2.setVisible(true);
				} else if (jt1.getText().equals("防控办") && jp1.getText().equals("123")) {
					lab1.setVisible(false);
					lab2.setVisible(false);
					jt1.setVisible(false);
					lab3.setVisible(false);
					jp1.setVisible(false);
					b.setVisible(false);
					button3.setVisible(true);
				} else {
					JFrame frame = new JFrame("错误提示");
					JPanel panel1 = new JPanel();
					panel1.setLayout(new BorderLayout());
					frame.add(panel1, BorderLayout.CENTER);
					frame.setBounds(100, 100, 200, 100);
					JLabel label = new JLabel("身份或密码错误！", Label.LEFT);
					panel1.add(label);
					frame.setVisible(true);
				}

			}
		});

		// 采集信息界面
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame("信息上报");
				FlowLayout flowLayout = new FlowLayout();
				frame.setLayout(flowLayout);
				frame.setBounds(200, 200, 800, 400);
				frame.setVisible(true);

				JPanel panel1 = new JPanel();
				panel1.setPreferredSize(new Dimension(700, 45));
				panel1.setLayout(new GridLayout(1, 4));
				JLabel label1 = new JLabel("姓名：");
				JTextField j1 = new JTextField("");
				JLabel label2 = new JLabel("学号：");
				JTextField j2 = new JTextField("");
				panel1.add(label1);
				panel1.add(j1);
				panel1.add(label2);
				panel1.add(j2);

				JPanel panel2 = new JPanel();
				panel2.setPreferredSize(new Dimension(700, 45));
				panel2.setLayout(new GridLayout(1, 4));
				JLabel label3 = new JLabel("学院：");
				JTextField j3 = new JTextField("");
				JLabel label4 = new JLabel("所在地：");
				JTextField j4 = new JTextField("");
				panel2.add(label3);
				panel2.add(j3);
				panel2.add(label4);
				panel2.add(j4);

				JPanel panel3 = new JPanel();
				panel3.setPreferredSize(new Dimension(700, 45));
				panel3.setLayout(new GridLayout(1, 4));
				JLabel label5 = new JLabel("是否与疫区人员接触");
				JPanel p1 = new JPanel();
				p1.setLayout(new GridLayout(2, 1));
				p1.setBorder(BorderFactory.createLineBorder(null));
				ButtonGroup bu = new ButtonGroup();
				JRadioButton jr1 = new JRadioButton("是");
				JRadioButton jr2 = new JRadioButton("否");
				JLabel label6 = new JLabel("是否发热");
				JPanel p2 = new JPanel();
				p2.setLayout(new GridLayout(2, 1));
				p2.setBorder(BorderFactory.createLineBorder(null));
				ButtonGroup bu1 = new ButtonGroup();
				JRadioButton jr3 = new JRadioButton("是");
				JRadioButton jr4 = new JRadioButton("否");
				bu.add(jr1);
				bu.add(jr2);
				p1.add(jr1);
				p1.add(jr2);
				panel3.add(label5);
				panel3.add(p1);
				bu1.add(jr3);
				bu1.add(jr4);
				p2.add(jr3);
				p2.add(jr4);
				panel3.add(label6);
				panel3.add(p2);

				JPanel panel4 = new JPanel();
				panel4.setPreferredSize(new Dimension(700, 45));
				panel4.setLayout(new GridLayout(1, 4));
				JLabel label7 = new JLabel("是否返校");
				JPanel p3 = new JPanel();
				p3.setLayout(new GridLayout(2, 1));
				p3.setBorder(BorderFactory.createLineBorder(null));
				ButtonGroup bu2 = new ButtonGroup();
				JRadioButton jr5 = new JRadioButton("是");
				JRadioButton jr6 = new JRadioButton("否");

				JLabel label8 = new JLabel("填报日期：");
				JTextField j5 = new JTextField("");

				bu2.add(jr5);
				bu2.add(jr6);
				p3.add(jr5);
				p3.add(jr6);
				panel4.add(label7);
				panel4.add(p3);
				panel4.add(label8);
				panel4.add(j5);

				frame.add(panel1);
				frame.add(panel2);
				frame.add(panel3);
				frame.add(panel4);

				JPanel panel5 = new JPanel();
				panel5.setPreferredSize(new Dimension(700, 45));
				JButton b1 = new JButton("提交");
				panel5.add(b1);
				JButton b2 = new JButton("清空");
				panel5.add(b2);
				frame.add(panel5);

				// 提交信息
				b1.addActionListener(new ActionListener() {
					@SuppressWarnings("resource")
					@Override
					public void actionPerformed(ActionEvent e) {
						button1.setVisible(false);
						button0.setVisible(true);
						// TODO 自动生成的方法存根

						try {
							FileInputStream fs = new FileInputStream("E://test.xls");// 获取e://test.xls
							POIFSFileSystem ps = new POIFSFileSystem(fs);// 使用POI提供的方法得到excel的信息
							HSSFWorkbook wb = new HSSFWorkbook(ps);
							HSSFSheet sheet = wb.getSheetAt(0); // 获取到工作表，因为一个excel可能有多个工作表
							HSSFRow row = sheet.getRow(0); // 获取第一行（excel中的行默认从0开始，所以这就是为什么，一个excel必须有字段列头），即，字段列头，便于赋值
							FileOutputStream out = new FileOutputStream("E://test.xls");// 向d://test.xls中写数据
							row = sheet.createRow((short) (sheet.getLastRowNum() + 1)); // 在现有行号后追加数据
							row.createCell(0).setCellValue(j1.getText()); // 设置第一个（从0开始）单元格的数据
							row.createCell(1).setCellValue(j2.getText()); // 设置第二个（从0开始）单元格的数据
							row.createCell(2).setCellValue(j3.getText());
							row.createCell(3).setCellValue(j4.getText());
							if (jr1.isSelected()) {
								row.createCell(4).setCellValue("是");
							}
							if (jr2.isSelected()) {
								row.createCell(4).setCellValue("否");
							}
							if (jr3.isSelected()) {
								row.createCell(5).setCellValue("是");
							}
							if (jr4.isSelected()) {
								row.createCell(5).setCellValue("否");
							}
							if (jr5.isSelected()) {
								row.createCell(6).setCellValue("是");
							}
							if (jr6.isSelected()) {
								row.createCell(6).setCellValue("否");
							}
							row.createCell(7).setCellValue(j5.getText());

							out.flush();
							wb.write(out);
							out.close();

						} catch (FileNotFoundException e2) {
							// TODO 自动生成的 catch 块
							System.out.println("信息文件找不到");
							e2.printStackTrace();
						} catch (IOException e1) {
							// TODO 自动生成的 catch 块
							System.out.println("信息文件读取错误");
							e1.printStackTrace();
						}

						frame.setVisible(false);
					}
				});
				// 清空选项按钮
				b2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						j1.setText(null);
						j2.setText(null);
						j3.setText(null);
						j4.setText(null);
						j5.setText(null);
						bu.clearSelection();
						bu1.clearSelection();
						bu2.clearSelection();

					}
				});
			}

		});

		// 设置重复提示，只可填写一次
		button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // TODO 自动生成的方法存根

				JFrame frame = new JFrame("错误提示");
				JPanel panel1 = new JPanel();
				panel1.setLayout(new BorderLayout());
				frame.add(panel1, BorderLayout.CENTER);
				frame.setBounds(100, 100, 200, 100);
				JLabel label = new JLabel("今日已填报，不可重复！", Label.LEFT);
				panel1.add(label);
				frame.setVisible(true);
			}
		});

		// 二级部门负责人查看界面
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				// 输入学院登录界面
				JFrame frame = new JFrame("登录");
				JPanel panel = new JPanel();
				panel.setLayout(null);
				frame.add(panel);
				frame.setBounds(100, 100, 400, 150);
				JLabel label = new JLabel("学院：", Label.LEFT);
				label.setBounds(0, 40, 100, 30);
				panel.add(label);
				JTextField jt = new JTextField("");
				jt.setBounds(110, 40, 100, 30);
				panel.add(jt);
				JButton button = new JButton("ok");
				button.setBounds(220, 40, 100, 30);
				panel.add(button);
				frame.setVisible(true);
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						frame.setVisible(false);

						JFrame frame = new JFrame("二级部门负责人查看界面");
						frame.setBounds(200, 200, 800, 400);
						frame.setLayout(new BorderLayout());
						frame.setVisible(true);
						JPanel panel = new JPanel();
						JTextArea jt0 = new JTextArea();
						panel.add(jt0);
						frame.add(panel, BorderLayout.NORTH);
						JPanel Panel1 = new JPanel();
						Panel1.setLayout(new GridLayout(2, 1));
						JButton jButton = new JButton("列出全部信息");
						JButton jButton1 = new JButton("是/否与疫区人员接触");
						JButton jButton2 = new JButton("是/否发热");
						JButton jButton3 = new JButton("是/否返校");
						JButton jButton01 = new JButton("是/否与疫区人员接触");
						JButton jButton02 = new JButton("是/否发热");
						JButton jButton03 = new JButton("是/否返校");

						JLabel lab2 = new JLabel("学号：", Label.LEFT);
						JTextField jt2 = new JTextField();
						JLabel lab4 = new JLabel("所在地：", Label.LEFT);
						JTextField jt4 = new JTextField();
						JLabel lab6 = new JLabel("姓名、日期：", Label.LEFT);
						JTextField jt6 = new JTextField();
						JTextField jt7 = new JTextField();

						JPanel p1 = new JPanel();
						p1.setLayout(null);
						jButton.setBounds(0, 0, 135, 25);
						jButton1.setBounds(270, 0, 135, 25);
						jButton2.setBounds(405, 0, 135, 25);
						jButton3.setBounds(540, 0, 135, 25);
						jButton01.setBounds(270, 0, 135, 25);
						jButton02.setBounds(405, 0, 135, 25);
						jButton03.setBounds(540, 0, 135, 25);
						JPanel p2 = new JPanel();
						p2.setLayout(new GridLayout(1, 7));

						p1.add(jButton);
						p1.add(jButton1);
						p1.add(jButton2);
						p1.add(jButton3);
						p1.add(jButton01);
						p1.add(jButton02);
						p1.add(jButton03);

						p2.add(lab2);
						p2.add(jt2);
						p2.add(lab4);
						p2.add(jt4);
						p2.add(lab6);
						p2.add(jt6);
						p2.add(jt7);
						Panel1.add(p1);
						Panel1.add(p2);
						frame.add(Panel1, BorderLayout.SOUTH);

						// 列出全部信息
						jButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO 自动生成的方法存根
								jt0.setText(null);
								File f = new File("E:\\test.xls");
								// 文件位于E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // 获得第一个工作表对象
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											for (int j = 0; j < sheet.getColumns(); j++) {
												Cell cell = sheet.getCell(j, i); // 获得单元格
												jt0.setText(jt0.getText() + cell.getContents() + " ");
											}
											jt0.setText(jt0.getText() + "\n");
										}

									}

								} catch (BiffException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

							}
						});

						// 是/否与疫区人员接触（是）
						jButton1.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO 自动生成的方法存根
								jt0.setText(null);
								jButton1.setVisible(false);
								jButton01.setVisible(true);
								File f = new File("E:\\test.xls");
								// 文件位于E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // 获得第一个工作表对象
									x = 0;
									y = 0;
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											if (sheet.getCell(4, i).getContents().equals("是")) {
												for (int j = 0; j < sheet.getColumns(); j++) {
													Cell cell = sheet.getCell(j, i); // 获得单元格
													jt0.setText(jt0.getText() + cell.getContents() + " ");
												}
												jt0.setText(jt0.getText() + "\n");
												y++;
											}
											x++;
										}

									}
									n = x - y;

								} catch (BiffException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								// 生成柱状图

								Test();
								JFrame frame = new JFrame("该数据的数量统计");
								frame.setLayout(new GridLayout(2, 2, 5, 5));
								frame.add(new Demo().getChartPanel()); // 添加柱形图
								frame.setBounds(0, 0, 500, 400);
								frame.setVisible(true);

							}
						});

						// 是/否发热（是）
						jButton2.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO 自动生成的方法存根
								jt0.setText(null);
								jButton2.setVisible(false);
								jButton02.setVisible(true);
								File f = new File("E:\\test.xls");
								// 文件位于E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // 获得第一个工作表对象
									x = 0;
									y = 0;
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											if (sheet.getCell(5, i).getContents().equals("是")) {
												for (int j = 0; j < sheet.getColumns(); j++) {
													Cell cell = sheet.getCell(j, i); // 获得单元格
													jt0.setText(jt0.getText() + cell.getContents() + " ");
												}
												jt0.setText(jt0.getText() + "\n");
												y++;
											}
											x++;
										}

									}
									n = x - y;

								} catch (BiffException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								// 生成柱状图

								Test();
								JFrame frame = new JFrame("该数据的数量统计");
								frame.setLayout(new GridLayout(2, 2, 5, 5));
								frame.add(new Demo().getChartPanel()); // 添加柱形图
								frame.setBounds(0, 0, 500, 400);
								frame.setVisible(true);

							}
						});

						// 是/否返校（是）
						jButton3.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO 自动生成的方法存根
								jt0.setText(null);
								jButton3.setVisible(false);
								jButton03.setVisible(true);
								File f = new File("E:\\test.xls");
								// 文件位于E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // 获得第一个工作表对象
									x = 0;
									y = 0;
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											if (sheet.getCell(6, i).getContents().equals("是")) {
												for (int j = 0; j < sheet.getColumns(); j++) {
													Cell cell = sheet.getCell(j, i); // 获得单元格
													jt0.setText(jt0.getText() + cell.getContents() + " ");
												}
												jt0.setText(jt0.getText() + "\n");
												y++;
											}
											x++;
										}

									}
									n = x - y;

								} catch (BiffException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

								// 生成柱状图
								Test();
								JFrame frame = new JFrame("该数据的数量统计");
								frame.setLayout(new GridLayout(2, 2, 5, 5));
								frame.add(new Demo().getChartPanel()); // 添加柱形图
								frame.setBounds(0, 0, 500, 400);
								frame.setVisible(true);

							}
						});

						// 是/否与疫区人员接触（否）
						jButton01.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO 自动生成的方法存根
								jt0.setText(null);
								jButton1.setVisible(true);
								jButton01.setVisible(false);
								File f = new File("E:\\test.xls");
								// 文件位于E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // 获得第一个工作表对象
									x = 0;
									n = 0;
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											if (sheet.getCell(4, i).getContents().equals("否")) {
												for (int j = 0; j < sheet.getColumns(); j++) {
													Cell cell = sheet.getCell(j, i); // 获得单元格
													jt0.setText(jt0.getText() + cell.getContents() + " ");
												}
												jt0.setText(jt0.getText() + "\n");
												n++;
											}
											x++;
										}

									}
									y = x - n;

								} catch (BiffException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								// 生成柱状图

								Test();
								JFrame frame = new JFrame("该数据的数量统计");
								frame.setLayout(new GridLayout(2, 2, 5, 5));
								frame.add(new Demo().getChartPanel()); // 添加柱形图
								frame.setBounds(0, 0, 500, 400);
								frame.setVisible(true);

							}
						});

						// 是/否发热（否）
						jButton02.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO 自动生成的方法存根
								jt0.setText(null);
								jButton2.setVisible(true);
								jButton02.setVisible(false);
								File f = new File("E:\\test.xls");
								// 文件位于E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // 获得第一个工作表对象
									x = 0;
									n = 0;
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											if (sheet.getCell(5, i).getContents().equals("否")) {
												for (int j = 0; j < sheet.getColumns(); j++) {
													Cell cell = sheet.getCell(j, i); // 获得单元格
													jt0.setText(jt0.getText() + cell.getContents() + " ");
												}
												jt0.setText(jt0.getText() + "\n");
												n++;
											}
											x++;
										}

									}
									y = x - n;

								} catch (BiffException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								// 生成柱状图

								Test();
								JFrame frame = new JFrame("该数据的数量统计");
								frame.setLayout(new GridLayout(2, 2, 5, 5));
								frame.add(new Demo().getChartPanel()); // 添加柱形图
								frame.setBounds(0, 0, 500, 400);
								frame.setVisible(true);

							}
						});

						// 是/否返校（否）
						jButton03.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO 自动生成的方法存根
								jt0.setText(null);
								jButton3.setVisible(true);
								jButton03.setVisible(false);
								File f = new File("E:\\test.xls");
								// 文件位于E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // 获得第一个工作表对象
									x = 0;
									n = 0;
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											if (sheet.getCell(6, i).getContents().equals("否")) {
												for (int j = 0; j < sheet.getColumns(); j++) {
													Cell cell = sheet.getCell(j, i); // 获得单元格
													jt0.setText(jt0.getText() + cell.getContents() + " ");
												}
												jt0.setText(jt0.getText() + "\n");
												n++;
											}
											x++;
										}

									}
									y = x - n;

								} catch (BiffException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

								// 生成柱状图
								Test();
								JFrame frame = new JFrame("该数据的数量统计");
								frame.setLayout(new GridLayout(2, 2, 5, 5));
								frame.add(new Demo().getChartPanel()); // 添加柱形图
								frame.setBounds(0, 0, 500, 400);
								frame.setVisible(true);

							}
						});

						// 按姓名/日期查询（姓名）
						jt6.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO 自动生成的方法存根
								jt0.setText(null);
								File f = new File("E:\\test.xls");
								// 文件位于E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // 获得第一个工作表对象

									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									if (jt7.getText().equals("")) {
										for (int i = 0; i < sheet.getRows(); i++) {
											if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
												if (sheet.getCell(0, i).getContents().equals(jt6.getText())) {
													for (int j = 0; j < sheet.getColumns(); j++) {
														Cell cell = sheet.getCell(j, i); // 获得单元格
														jt0.setText(jt0.getText() + cell.getContents() + " ");
													}
													jt0.setText(jt0.getText() + "\n");
												}
											}

										}
									} else {
										for (int i = 0; i < sheet.getRows(); i++) {
											if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
												if (sheet.getCell(0, i).getContents().equals(jt6.getText())
														&& sheet.getCell(7, i).getContents().equals(jt7.getText())) {
													for (int j = 0; j < sheet.getColumns(); j++) {
														Cell cell = sheet.getCell(j, i); // 获得单元格
														jt0.setText(jt0.getText() + cell.getContents() + " ");
													}
													jt0.setText(jt0.getText() + "\n");
												}
											}

										}
									}

								} catch (BiffException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

							}
						});
						// 按姓名/日期查询（日期）
						jt7.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO 自动生成的方法存根
								jt0.setText(null);
								File f = new File("E:\\test.xls");
								// 文件位于E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // 获得第一个工作表对象

									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									if (jt6.getText().equals("")) {
										for (int i = 0; i < sheet.getRows(); i++) {
											if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
												if (sheet.getCell(7, i).getContents().equals(jt7.getText())) {
													for (int j = 0; j < sheet.getColumns(); j++) {
														Cell cell = sheet.getCell(j, i); // 获得单元格
														jt0.setText(jt0.getText() + cell.getContents() + " ");
													}
													jt0.setText(jt0.getText() + "\n");
												}
											}

										}
									} else {
										for (int i = 0; i < sheet.getRows(); i++) {
											if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
												if (sheet.getCell(0, i).getContents().equals(jt6.getText())
														&& sheet.getCell(7, i).getContents().equals(jt7.getText())) {
													for (int j = 0; j < sheet.getColumns(); j++) {
														Cell cell = sheet.getCell(j, i); // 获得单元格
														jt0.setText(jt0.getText() + cell.getContents() + " ");
													}
													jt0.setText(jt0.getText() + "\n");
												}
											}

										}
									}

								} catch (BiffException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

							}
						});

						// 按学号查询
						jt2.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO 自动生成的方法存根
								jt0.setText(null);
								File f = new File("E:\\test.xls");
								// 文件位于E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // 获得第一个工作表对象

									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											if (sheet.getCell(1, i).getContents().equals(jt2.getText())) {
												for (int j = 0; j < sheet.getColumns(); j++) {
													Cell cell = sheet.getCell(j, i); // 获得单元格
													jt0.setText(jt0.getText() + cell.getContents() + " ");
												}
												jt0.setText(jt0.getText() + "\n");
											}
										}

									}

								} catch (BiffException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

							}
						});

						// 按所在地查询
						jt4.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO 自动生成的方法存根
								jt0.setText(null);
								File f = new File("E:\\test.xls");
								// 文件位于E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // 获得第一个工作表对象

									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											if (sheet.getCell(3, i).getContents().equals(jt4.getText())) {
												for (int j = 0; j < sheet.getColumns(); j++) {
													Cell cell = sheet.getCell(j, i); // 获得单元格
													jt0.setText(jt0.getText() + cell.getContents() + " ");
												}
												jt0.setText(jt0.getText() + "\n");
											}
										}

									}

								} catch (BiffException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

							}
						});

					}
				});
			}
		});

		// 防控办负责人查看界面
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根

				JFrame frame = new JFrame("防控办负责人查看界面");
				frame.setBounds(200, 200, 900, 400);
				frame.setLayout(new BorderLayout());
				frame.setVisible(true);
				JPanel panel = new JPanel();
				JTextArea jt0 = new JTextArea();
				panel.add(jt0);
				frame.add(panel, BorderLayout.NORTH);
				JPanel Panel1 = new JPanel();
				Panel1.setLayout(new GridLayout(3, 1));
				JButton jButton = new JButton("列出全部信息");
				JButton jButton1 = new JButton("是/否与疫区人员接触");
				JButton jButton2 = new JButton("是/否发热");
				JButton jButton3 = new JButton("是/否返校");
				JButton jButton01 = new JButton("是/否与疫区人员接触");
				JButton jButton02 = new JButton("是/否发热");
				JButton jButton03 = new JButton("是/否返校");
				JButton lab1 = new JButton("某日是/否填报情况");
				JButton lab01 = new JButton("某日是/否填报情况");
				JTextField jt1 = new JTextField();

				JLabel lab2 = new JLabel("学号：", Label.LEFT);
				JTextField jt2 = new JTextField();
				JLabel lab3 = new JLabel("学院：", Label.LEFT);
				JTextField jt3 = new JTextField();
				JLabel lab4 = new JLabel("所在地：", Label.LEFT);
				JTextField jt4 = new JTextField();

				JLabel lab6 = new JLabel("姓名、日期：", Label.LEFT);
				JTextField jt6 = new JTextField();
				JTextField jt7 = new JTextField();
				JLabel kb2 = new JLabel("");
				JLabel kb3 = new JLabel("");
				JButton jButton4 = new JButton("导出exl文件");

				JPanel p1 = new JPanel();
				p1.setLayout(null);
				jButton.setBounds(0, 0, 150, 25);
				jButton1.setBounds(150, 0, 150, 25);
				jButton2.setBounds(300, 0, 150, 25);
				jButton3.setBounds(450, 0, 150, 25);
				jButton01.setBounds(150, 0, 150, 25);
				jButton02.setBounds(300, 0, 150, 25);
				jButton03.setBounds(450, 0, 150, 25);
				lab1.setBounds(600, 0, 150, 25);
				lab01.setBounds(600, 0, 150, 25);
				jt1.setBounds(750, 0, 150, 25);
				JPanel p2 = new JPanel();
				p2.setLayout(new GridLayout(1, 6));
				JPanel p3 = new JPanel();
				p3.setLayout(new GridLayout(1, 6));

				p1.add(jButton);
				p1.add(jButton1);
				p1.add(jButton2);
				p1.add(jButton3);
				p1.add(jButton01);
				p1.add(jButton02);
				p1.add(jButton03);
				p1.add(lab1);
				p1.add(lab01);
				p1.add(jt1);

				p2.add(lab2);
				p2.add(jt2);
				p2.add(lab3);
				p2.add(jt3);
				p2.add(lab4);
				p2.add(jt4);

				p3.add(lab6);
				p3.add(jt6);
				p3.add(jt7);
				p3.add(kb2);
				p3.add(kb3);
				p3.add(jButton4);
				Panel1.add(p1);
				Panel1.add(p2);
				Panel1.add(p3);
				frame.add(Panel1, BorderLayout.SOUTH);

				// 列出全部信息
				jButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						jt0.setText(null);
						File f = new File("E:\\test.xls");
						// 文件位于E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // 获得第一个工作表对象

							for (int i = 0; i < sheet.getRows(); i++) {
								for (int j = 0; j < sheet.getColumns(); j++) {
									Cell cell = sheet.getCell(j, i); // 获得单元格
									jt0.setText(jt0.getText() + cell.getContents() + " ");
								}
								jt0.setText(jt0.getText() + "\n");
							}

						} catch (BiffException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});

				// 是/否与疫区人员接触（是）
				jButton1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						jt0.setText(null);
						jButton1.setVisible(false);
						jButton01.setVisible(true);
						File f = new File("E:\\test.xls");
						// 文件位于E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // 获得第一个工作表对象
							x = sheet.getRows() - 1;
							y = 0;
							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(4, i).getContents().equals("是")) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // 获得单元格
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									y++;
								}
							}
							n = x - y;

						} catch (BiffException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// 生成柱状图

						Test();
						JFrame frame = new JFrame("该数据的数量统计");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Demo().getChartPanel()); // 添加柱形图
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);

					}
				});

				// 是/否发热（是）
				jButton2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						jt0.setText(null);
						jButton2.setVisible(false);
						jButton02.setVisible(true);
						File f = new File("E:\\test.xls");
						// 文件位于E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // 获得第一个工作表对象
							x = sheet.getRows() - 1;
							y = 0;
							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(5, i).getContents().equals("是")) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // 获得单元格
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									y++;
								}
							}
							n = x - y;

						} catch (BiffException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// 生成柱状图

						Test();
						JFrame frame = new JFrame("该数据的数量统计");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Demo().getChartPanel()); // 添加柱形图
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);

					}
				});

				// 是/否返校（是）
				jButton3.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						jt0.setText(null);
						jButton3.setVisible(false);
						jButton03.setVisible(true);
						File f = new File("E:\\test.xls");
						// 文件位于E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // 获得第一个工作表对象
							x = sheet.getRows() - 1;
							y = 0;
							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(6, i).getContents().equals("是")) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // 获得单元格
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									y++;
								}
							}
							n = x - y;

						} catch (BiffException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						// 生成柱状图
						Test();
						JFrame frame = new JFrame("该数据的数量统计");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Demo().getChartPanel()); // 添加柱形图
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);

					}
				});

				// 是/否与疫区人员接触（否）
				jButton01.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						jt0.setText(null);
						jButton1.setVisible(true);
						jButton01.setVisible(false);
						File f = new File("E:\\test.xls");
						// 文件位于E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // 获得第一个工作表对象
							x = sheet.getRows() - 1;
							n = 0;
							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(4, i).getContents().equals("否")) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // 获得单元格
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									n++;
								}
							}
							y = x - n;

						} catch (BiffException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// 生成柱状图

						Test();
						JFrame frame = new JFrame("该数据的数量统计");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Demo().getChartPanel()); // 添加柱形图
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);

					}
				});

				// 是/否发热（否）
				jButton02.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						jt0.setText(null);
						jButton2.setVisible(true);
						jButton02.setVisible(false);
						File f = new File("E:\\test.xls");
						// 文件位于E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // 获得第一个工作表对象
							x = sheet.getRows() - 1;
							n = 0;
							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(5, i).getContents().equals("否")) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // 获得单元格
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									n++;
								}
							}
							y = x - n;

						} catch (BiffException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// 生成柱状图

						Test();
						JFrame frame = new JFrame("该数据的数量统计");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Demo().getChartPanel()); // 添加柱形图
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);

					}
				});

				// 是/否返校（否）
				jButton03.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						jt0.setText(null);
						jButton3.setVisible(true);
						jButton03.setVisible(false);
						File f = new File("E:\\test.xls");
						// 文件位于E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // 获得第一个工作表对象
							x = sheet.getRows() - 1;
							n = 0;
							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(6, i).getContents().equals("否")) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // 获得单元格
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									n++;
								}
							}
							y = x - n;

						} catch (BiffException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						// 生成柱状图
						Test();
						JFrame frame = new JFrame("该数据的数量统计");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Demo().getChartPanel()); // 添加柱形图
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);

					}
				});

				// 某日是/否填报情况（是）
				lab1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						jt0.setText(null);
						lab01.setVisible(true);
						lab1.setVisible(false);
						File f = new File("E:\\test.xls");
						File f1 = new File("E:\\人员信息.xls");
						// 文件位于E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // 获得第一个工作表对象
							Workbook book1 = Workbook.getWorkbook(f1);
							Sheet sheet1 = book1.getSheet(0); // 获得第一个工作表对象
							x = sheet1.getRows();
							y = 0;
							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(7, i).getContents().equals(jt1.getText())) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // 获得单元格
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									y++;
								}
							}
							n = x - y;

						} catch (BiffException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// 生成柱状图
						Test();
						JFrame frame = new JFrame("该数据的数量统计");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Demo().getChartPanel()); // 添加柱形图
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					}
				});

				// 某日是/否填报情况（否）
				lab01.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						jt0.setText(null);
						lab1.setVisible(true);
						lab01.setVisible(false);
						File f = new File("E:\\test.xls");
						File f1 = new File("E:\\人员信息.xls");
						// 文件位于E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // 获得第一个工作表对象
							Workbook book1 = Workbook.getWorkbook(f1);
							Sheet sheet1 = book1.getSheet(0); // 获得第一个工作表对象
							x = sheet1.getRows();
							n = 0;
							int l[] = new int[x];
							jt0.setText("未填写人员" + "\n");
							for (int k = 0; k < sheet1.getRows(); k++) {
								for (int i = 0; i < sheet.getRows(); i++) {
									if (sheet.getCell(7, i).getContents().equals(jt1.getText())) {
										if (sheet1.getCell(0, k).getContents()
												.equals(sheet.getCell(0, i).getContents()))
											l[k]++;
									}
								}
								if (l[k] == 0) {
									jt0.setText(jt0.getText() + sheet1.getCell(0, k).getContents() + "\n");
									n++;
								}
							}
							y = x - n;

						} catch (BiffException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// 生成柱状图
						Test();
						JFrame frame = new JFrame("该数据的数量统计");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Demo().getChartPanel()); // 添加柱形图
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					}
				});

				// 按姓名/日期查询（姓名）
				jt6.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						jt0.setText(null);
						File f = new File("E:\\test.xls");
						// 文件位于E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // 获得第一个工作表对象

							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							if (jt7.getText().equals("")) {
								for (int i = 0; i < sheet.getRows(); i++) {
									if (sheet.getCell(0, i).getContents().equals(jt6.getText())) {
										for (int j = 0; j < sheet.getColumns(); j++) {
											Cell cell = sheet.getCell(j, i); // 获得单元格
											jt0.setText(jt0.getText() + cell.getContents() + " ");
										}
										jt0.setText(jt0.getText() + "\n");
									}
								}
							} else {
								for (int i = 0; i < sheet.getRows(); i++) {
									if (sheet.getCell(0, i).getContents().equals(jt6.getText())
											&& sheet.getCell(7, i).getContents().equals(jt7.getText())) {
										for (int j = 0; j < sheet.getColumns(); j++) {
											Cell cell = sheet.getCell(j, i); // 获得单元格
											jt0.setText(jt0.getText() + cell.getContents() + " ");
										}
										jt0.setText(jt0.getText() + "\n");
									}
								}
							}

						} catch (BiffException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});
				// 按姓名/日期查询（日期）
				jt7.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						jt0.setText(null);
						File f = new File("E:\\test.xls");
						// 文件位于E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // 获得第一个工作表对象

							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							if (jt6.getText().equals("")) {
								for (int i = 0; i < sheet.getRows(); i++) {
									if (sheet.getCell(7, i).getContents().equals(jt7.getText())) {
										for (int j = 0; j < sheet.getColumns(); j++) {
											Cell cell = sheet.getCell(j, i); // 获得单元格
											jt0.setText(jt0.getText() + cell.getContents() + " ");
										}
										jt0.setText(jt0.getText() + "\n");
									}
								}
							} else {
								for (int i = 0; i < sheet.getRows(); i++) {
									if (sheet.getCell(0, i).getContents().equals(jt6.getText())
											&& sheet.getCell(7, i).getContents().equals(jt7.getText())) {
										for (int j = 0; j < sheet.getColumns(); j++) {
											Cell cell = sheet.getCell(j, i); // 获得单元格
											jt0.setText(jt0.getText() + cell.getContents() + " ");
										}
										jt0.setText(jt0.getText() + "\n");
									}
								}
							}

						} catch (BiffException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});

				// 按学号查询
				jt2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						jt0.setText(null);
						File f = new File("E:\\test.xls");
						// 文件位于E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // 获得第一个工作表对象

							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(1, i).getContents().equals(jt2.getText())) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // 获得单元格
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
								}
							}

						} catch (BiffException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});

				// 按学院查询
				jt3.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						jt0.setText(null);
						File f = new File("E:\\test.xls");
						// 文件位于E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // 获得第一个工作表对象

							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(2, i).getContents().equals(jt3.getText())) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // 获得单元格
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
								}
							}

						} catch (BiffException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});

				// 按所在地查询
				jt4.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						jt0.setText(null);
						File f = new File("E:\\test.xls");
						// 文件位于E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // 获得第一个工作表对象

							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(3, i).getContents().equals(jt4.getText())) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // 获得单元格
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
								}
							}

						} catch (BiffException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});

				// 导出xls表
				jButton4.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						jt0.setText(null);
						FileInputStream fis;
						try {
							fis = new FileInputStream("E:/test.xls");
							FileOutputStream fos = new FileOutputStream("E:/疫情信息.xls");
							byte[] bs = new byte[1024];
							int len = -1;
							while ((len = fis.read(bs)) != -1) {
								fos.write(bs, 0, len);
							}
							fos.close();
							fis.close();
						} catch (FileNotFoundException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}

					}
				});

			}
		});

	}

	// 生成柱状图
	private static void Test() {
		// TODO 自动生成的方法存根
		CategoryDataset dataset = getDataSet();// 将获得的数据传递给CategoryDataset类的对象
		JFreeChart chart = ChartFactory.createBarChart3D("人数统计表", // 图表标题
				"人数信息", // 目录轴的显示标签
				"人数/个", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
		);

		CategoryPlot plot = chart.getCategoryPlot();// 获取图表区域对象
		CategoryAxis domainAxis = plot.getDomainAxis(); // 水平底部列表
		domainAxis.setLabelFont(new Font("黑体", Font.BOLD, 14)); // 水平底部标题
		domainAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12)); // 垂直标题
		ValueAxis rangeAxis = plot.getRangeAxis();// 获取柱状
		rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));// 设置标题字体

		frame1 = new ChartPanel(chart, true); // 这里也可以用chartFrame,可以直接生成一个独立的Frame

	}

	private static CategoryDataset getDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(y, "是", "是");
		dataset.addValue(n, "否", "否");
		return dataset;
	}

	public ChartPanel getChartPanel() {
		return frame1;

	}

}