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
	// ��״ͼ����
	static ChartPanel frame1;
	static int x, y, n;

	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.run();

	}

	public void run() {
		// ������
		JFrame frame = new JFrame("����ʦ����ѧ�����ϱ�ϵͳ");
		JPanel panel1 = new JPanel();
		// panel1.setLayout(new GridLayout(3, 1));
		panel1.setLayout(null);
		frame.add(panel1);
		frame.setBounds(10, 10, 500, 350);
		Button button1 = new Button("������Ϣ�ϱ�");
		button1.setBounds(175, 50, 150, 30);
		button1.setVisible(false);
		panel1.add(button1);
		Button button0 = new Button("������Ϣ�ϱ�");
		button0.setBounds(175, 50, 150, 30);
		button0.setVisible(false);
		panel1.add(button0);
		Button button2 = new Button("�������Ÿ��������");
		button2.setBounds(175, 130, 150, 30);
		button2.setVisible(false);
		panel1.add(button2);
		Button button3 = new Button("���ذ츺�������");
		button3.setBounds(175, 210, 150, 30);
		button3.setVisible(false);
		panel1.add(button3);

		Image image = new ImageIcon("school.jpg").getImage();
		image = image.getScaledInstance(400, 100, 0);
		JLabel lab1 = new JLabel(new ImageIcon(image));
		lab1.setBounds(50, 0, 400, 100);
		panel1.add(lab1);

		JLabel lab2 = new JLabel("��ݣ�", Label.LEFT);
		lab2.setBounds(100, 110, 150, 30);
		JTextField jt1 = new JTextField();
		jt1.setBounds(250, 110, 150, 30);
		JLabel lab3 = new JLabel("���룺", Label.LEFT);
		lab3.setBounds(100, 150, 150, 30);
		JPasswordField jp1 = new JPasswordField();
		jp1.setBounds(250, 150, 150, 30);
		JButton b = new JButton("����");
		b.setBounds(200, 190, 100, 30);
		panel1.add(lab2);
		panel1.add(jt1);
		panel1.add(lab3);
		panel1.add(jp1);
		panel1.add(b);
		frame.setVisible(true);

		// �������
		b.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if (jt1.getText().equals("ѧ��") && jp1.getText().equals("123")) {
					lab1.setVisible(false);
					lab2.setVisible(false);
					jt1.setVisible(false);
					lab3.setVisible(false);
					jp1.setVisible(false);
					b.setVisible(false);
					button1.setVisible(true);
				}
				else if (jt1.getText().equals("��ʦ") && jp1.getText().equals("123")) {
					lab1.setVisible(false);
					lab2.setVisible(false);
					jt1.setVisible(false);
					lab3.setVisible(false);
					jp1.setVisible(false);
					b.setVisible(false);
					button1.setVisible(true);
				}
				else if (jt1.getText().equals("��������") && jp1.getText().equals("123")) {
					lab1.setVisible(false);
					lab2.setVisible(false);
					jt1.setVisible(false);
					lab3.setVisible(false);
					jp1.setVisible(false);
					b.setVisible(false);
					button2.setVisible(true);
				} else if (jt1.getText().equals("���ذ�") && jp1.getText().equals("123")) {
					lab1.setVisible(false);
					lab2.setVisible(false);
					jt1.setVisible(false);
					lab3.setVisible(false);
					jp1.setVisible(false);
					b.setVisible(false);
					button3.setVisible(true);
				} else {
					JFrame frame = new JFrame("������ʾ");
					JPanel panel1 = new JPanel();
					panel1.setLayout(new BorderLayout());
					frame.add(panel1, BorderLayout.CENTER);
					frame.setBounds(100, 100, 200, 100);
					JLabel label = new JLabel("��ݻ��������", Label.LEFT);
					panel1.add(label);
					frame.setVisible(true);
				}

			}
		});

		// �ɼ���Ϣ����
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame("��Ϣ�ϱ�");
				FlowLayout flowLayout = new FlowLayout();
				frame.setLayout(flowLayout);
				frame.setBounds(200, 200, 800, 400);
				frame.setVisible(true);

				JPanel panel1 = new JPanel();
				panel1.setPreferredSize(new Dimension(700, 45));
				panel1.setLayout(new GridLayout(1, 4));
				JLabel label1 = new JLabel("������");
				JTextField j1 = new JTextField("");
				JLabel label2 = new JLabel("ѧ�ţ�");
				JTextField j2 = new JTextField("");
				panel1.add(label1);
				panel1.add(j1);
				panel1.add(label2);
				panel1.add(j2);

				JPanel panel2 = new JPanel();
				panel2.setPreferredSize(new Dimension(700, 45));
				panel2.setLayout(new GridLayout(1, 4));
				JLabel label3 = new JLabel("ѧԺ��");
				JTextField j3 = new JTextField("");
				JLabel label4 = new JLabel("���ڵأ�");
				JTextField j4 = new JTextField("");
				panel2.add(label3);
				panel2.add(j3);
				panel2.add(label4);
				panel2.add(j4);

				JPanel panel3 = new JPanel();
				panel3.setPreferredSize(new Dimension(700, 45));
				panel3.setLayout(new GridLayout(1, 4));
				JLabel label5 = new JLabel("�Ƿ���������Ա�Ӵ�");
				JPanel p1 = new JPanel();
				p1.setLayout(new GridLayout(2, 1));
				p1.setBorder(BorderFactory.createLineBorder(null));
				ButtonGroup bu = new ButtonGroup();
				JRadioButton jr1 = new JRadioButton("��");
				JRadioButton jr2 = new JRadioButton("��");
				JLabel label6 = new JLabel("�Ƿ���");
				JPanel p2 = new JPanel();
				p2.setLayout(new GridLayout(2, 1));
				p2.setBorder(BorderFactory.createLineBorder(null));
				ButtonGroup bu1 = new ButtonGroup();
				JRadioButton jr3 = new JRadioButton("��");
				JRadioButton jr4 = new JRadioButton("��");
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
				JLabel label7 = new JLabel("�Ƿ�У");
				JPanel p3 = new JPanel();
				p3.setLayout(new GridLayout(2, 1));
				p3.setBorder(BorderFactory.createLineBorder(null));
				ButtonGroup bu2 = new ButtonGroup();
				JRadioButton jr5 = new JRadioButton("��");
				JRadioButton jr6 = new JRadioButton("��");

				JLabel label8 = new JLabel("����ڣ�");
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
				JButton b1 = new JButton("�ύ");
				panel5.add(b1);
				JButton b2 = new JButton("���");
				panel5.add(b2);
				frame.add(panel5);

				// �ύ��Ϣ
				b1.addActionListener(new ActionListener() {
					@SuppressWarnings("resource")
					@Override
					public void actionPerformed(ActionEvent e) {
						button1.setVisible(false);
						button0.setVisible(true);
						// TODO �Զ����ɵķ������

						try {
							FileInputStream fs = new FileInputStream("E://test.xls");// ��ȡe://test.xls
							POIFSFileSystem ps = new POIFSFileSystem(fs);// ʹ��POI�ṩ�ķ����õ�excel����Ϣ
							HSSFWorkbook wb = new HSSFWorkbook(ps);
							HSSFSheet sheet = wb.getSheetAt(0); // ��ȡ����������Ϊһ��excel�����ж��������
							HSSFRow row = sheet.getRow(0); // ��ȡ��һ�У�excel�е���Ĭ�ϴ�0��ʼ�����������Ϊʲô��һ��excel�������ֶ���ͷ���������ֶ���ͷ�����ڸ�ֵ
							FileOutputStream out = new FileOutputStream("E://test.xls");// ��d://test.xls��д����
							row = sheet.createRow((short) (sheet.getLastRowNum() + 1)); // �������кź�׷������
							row.createCell(0).setCellValue(j1.getText()); // ���õ�һ������0��ʼ����Ԫ�������
							row.createCell(1).setCellValue(j2.getText()); // ���õڶ�������0��ʼ����Ԫ�������
							row.createCell(2).setCellValue(j3.getText());
							row.createCell(3).setCellValue(j4.getText());
							if (jr1.isSelected()) {
								row.createCell(4).setCellValue("��");
							}
							if (jr2.isSelected()) {
								row.createCell(4).setCellValue("��");
							}
							if (jr3.isSelected()) {
								row.createCell(5).setCellValue("��");
							}
							if (jr4.isSelected()) {
								row.createCell(5).setCellValue("��");
							}
							if (jr5.isSelected()) {
								row.createCell(6).setCellValue("��");
							}
							if (jr6.isSelected()) {
								row.createCell(6).setCellValue("��");
							}
							row.createCell(7).setCellValue(j5.getText());

							out.flush();
							wb.write(out);
							out.close();

						} catch (FileNotFoundException e2) {
							// TODO �Զ����ɵ� catch ��
							System.out.println("��Ϣ�ļ��Ҳ���");
							e2.printStackTrace();
						} catch (IOException e1) {
							// TODO �Զ����ɵ� catch ��
							System.out.println("��Ϣ�ļ���ȡ����");
							e1.printStackTrace();
						}

						frame.setVisible(false);
					}
				});
				// ���ѡ�ť
				b2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
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

		// �����ظ���ʾ��ֻ����дһ��
		button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // TODO �Զ����ɵķ������

				JFrame frame = new JFrame("������ʾ");
				JPanel panel1 = new JPanel();
				panel1.setLayout(new BorderLayout());
				frame.add(panel1, BorderLayout.CENTER);
				frame.setBounds(100, 100, 200, 100);
				JLabel label = new JLabel("��������������ظ���", Label.LEFT);
				panel1.add(label);
				frame.setVisible(true);
			}
		});

		// �������Ÿ����˲鿴����
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				// ����ѧԺ��¼����
				JFrame frame = new JFrame("��¼");
				JPanel panel = new JPanel();
				panel.setLayout(null);
				frame.add(panel);
				frame.setBounds(100, 100, 400, 150);
				JLabel label = new JLabel("ѧԺ��", Label.LEFT);
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
						// TODO �Զ����ɵķ������
						frame.setVisible(false);

						JFrame frame = new JFrame("�������Ÿ����˲鿴����");
						frame.setBounds(200, 200, 800, 400);
						frame.setLayout(new BorderLayout());
						frame.setVisible(true);
						JPanel panel = new JPanel();
						JTextArea jt0 = new JTextArea();
						panel.add(jt0);
						frame.add(panel, BorderLayout.NORTH);
						JPanel Panel1 = new JPanel();
						Panel1.setLayout(new GridLayout(2, 1));
						JButton jButton = new JButton("�г�ȫ����Ϣ");
						JButton jButton1 = new JButton("��/����������Ա�Ӵ�");
						JButton jButton2 = new JButton("��/����");
						JButton jButton3 = new JButton("��/��У");
						JButton jButton01 = new JButton("��/����������Ա�Ӵ�");
						JButton jButton02 = new JButton("��/����");
						JButton jButton03 = new JButton("��/��У");

						JLabel lab2 = new JLabel("ѧ�ţ�", Label.LEFT);
						JTextField jt2 = new JTextField();
						JLabel lab4 = new JLabel("���ڵأ�", Label.LEFT);
						JTextField jt4 = new JTextField();
						JLabel lab6 = new JLabel("���������ڣ�", Label.LEFT);
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

						// �г�ȫ����Ϣ
						jButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO �Զ����ɵķ������
								jt0.setText(null);
								File f = new File("E:\\test.xls");
								// �ļ�λ��E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // ��õ�һ�����������
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											for (int j = 0; j < sheet.getColumns(); j++) {
												Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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

						// ��/����������Ա�Ӵ����ǣ�
						jButton1.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO �Զ����ɵķ������
								jt0.setText(null);
								jButton1.setVisible(false);
								jButton01.setVisible(true);
								File f = new File("E:\\test.xls");
								// �ļ�λ��E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // ��õ�һ�����������
									x = 0;
									y = 0;
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											if (sheet.getCell(4, i).getContents().equals("��")) {
												for (int j = 0; j < sheet.getColumns(); j++) {
													Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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
								// ������״ͼ

								Test();
								JFrame frame = new JFrame("�����ݵ�����ͳ��");
								frame.setLayout(new GridLayout(2, 2, 5, 5));
								frame.add(new Demo().getChartPanel()); // �������ͼ
								frame.setBounds(0, 0, 500, 400);
								frame.setVisible(true);

							}
						});

						// ��/���ȣ��ǣ�
						jButton2.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO �Զ����ɵķ������
								jt0.setText(null);
								jButton2.setVisible(false);
								jButton02.setVisible(true);
								File f = new File("E:\\test.xls");
								// �ļ�λ��E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // ��õ�һ�����������
									x = 0;
									y = 0;
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											if (sheet.getCell(5, i).getContents().equals("��")) {
												for (int j = 0; j < sheet.getColumns(); j++) {
													Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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
								// ������״ͼ

								Test();
								JFrame frame = new JFrame("�����ݵ�����ͳ��");
								frame.setLayout(new GridLayout(2, 2, 5, 5));
								frame.add(new Demo().getChartPanel()); // �������ͼ
								frame.setBounds(0, 0, 500, 400);
								frame.setVisible(true);

							}
						});

						// ��/��У���ǣ�
						jButton3.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO �Զ����ɵķ������
								jt0.setText(null);
								jButton3.setVisible(false);
								jButton03.setVisible(true);
								File f = new File("E:\\test.xls");
								// �ļ�λ��E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // ��õ�һ�����������
									x = 0;
									y = 0;
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											if (sheet.getCell(6, i).getContents().equals("��")) {
												for (int j = 0; j < sheet.getColumns(); j++) {
													Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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

								// ������״ͼ
								Test();
								JFrame frame = new JFrame("�����ݵ�����ͳ��");
								frame.setLayout(new GridLayout(2, 2, 5, 5));
								frame.add(new Demo().getChartPanel()); // �������ͼ
								frame.setBounds(0, 0, 500, 400);
								frame.setVisible(true);

							}
						});

						// ��/����������Ա�Ӵ�����
						jButton01.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO �Զ����ɵķ������
								jt0.setText(null);
								jButton1.setVisible(true);
								jButton01.setVisible(false);
								File f = new File("E:\\test.xls");
								// �ļ�λ��E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // ��õ�һ�����������
									x = 0;
									n = 0;
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											if (sheet.getCell(4, i).getContents().equals("��")) {
												for (int j = 0; j < sheet.getColumns(); j++) {
													Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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
								// ������״ͼ

								Test();
								JFrame frame = new JFrame("�����ݵ�����ͳ��");
								frame.setLayout(new GridLayout(2, 2, 5, 5));
								frame.add(new Demo().getChartPanel()); // �������ͼ
								frame.setBounds(0, 0, 500, 400);
								frame.setVisible(true);

							}
						});

						// ��/���ȣ���
						jButton02.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO �Զ����ɵķ������
								jt0.setText(null);
								jButton2.setVisible(true);
								jButton02.setVisible(false);
								File f = new File("E:\\test.xls");
								// �ļ�λ��E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // ��õ�һ�����������
									x = 0;
									n = 0;
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											if (sheet.getCell(5, i).getContents().equals("��")) {
												for (int j = 0; j < sheet.getColumns(); j++) {
													Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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
								// ������״ͼ

								Test();
								JFrame frame = new JFrame("�����ݵ�����ͳ��");
								frame.setLayout(new GridLayout(2, 2, 5, 5));
								frame.add(new Demo().getChartPanel()); // �������ͼ
								frame.setBounds(0, 0, 500, 400);
								frame.setVisible(true);

							}
						});

						// ��/��У����
						jButton03.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO �Զ����ɵķ������
								jt0.setText(null);
								jButton3.setVisible(true);
								jButton03.setVisible(false);
								File f = new File("E:\\test.xls");
								// �ļ�λ��E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // ��õ�һ�����������
									x = 0;
									n = 0;
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											if (sheet.getCell(6, i).getContents().equals("��")) {
												for (int j = 0; j < sheet.getColumns(); j++) {
													Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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

								// ������״ͼ
								Test();
								JFrame frame = new JFrame("�����ݵ�����ͳ��");
								frame.setLayout(new GridLayout(2, 2, 5, 5));
								frame.add(new Demo().getChartPanel()); // �������ͼ
								frame.setBounds(0, 0, 500, 400);
								frame.setVisible(true);

							}
						});

						// ������/���ڲ�ѯ��������
						jt6.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO �Զ����ɵķ������
								jt0.setText(null);
								File f = new File("E:\\test.xls");
								// �ļ�λ��E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // ��õ�һ�����������

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
														Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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
														Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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
						// ������/���ڲ�ѯ�����ڣ�
						jt7.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO �Զ����ɵķ������
								jt0.setText(null);
								File f = new File("E:\\test.xls");
								// �ļ�λ��E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // ��õ�һ�����������

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
														Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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
														Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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

						// ��ѧ�Ų�ѯ
						jt2.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO �Զ����ɵķ������
								jt0.setText(null);
								File f = new File("E:\\test.xls");
								// �ļ�λ��E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // ��õ�һ�����������

									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											if (sheet.getCell(1, i).getContents().equals(jt2.getText())) {
												for (int j = 0; j < sheet.getColumns(); j++) {
													Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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

						// �����ڵز�ѯ
						jt4.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO �Զ����ɵķ������
								jt0.setText(null);
								File f = new File("E:\\test.xls");
								// �ļ�λ��E:\\test.xls
								try {
									Workbook book = Workbook.getWorkbook(f);
									Sheet sheet = book.getSheet(0); // ��õ�һ�����������

									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, 0);
										jt0.setText(jt0.getText() + cell.getContents() + " ");
									}
									jt0.setText(jt0.getText() + "\n");
									for (int i = 0; i < sheet.getRows(); i++) {
										if (jt.getText().equals(sheet.getCell(2, i).getContents())) {
											if (sheet.getCell(3, i).getContents().equals(jt4.getText())) {
												for (int j = 0; j < sheet.getColumns(); j++) {
													Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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

		// ���ذ츺���˲鿴����
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������

				JFrame frame = new JFrame("���ذ츺���˲鿴����");
				frame.setBounds(200, 200, 900, 400);
				frame.setLayout(new BorderLayout());
				frame.setVisible(true);
				JPanel panel = new JPanel();
				JTextArea jt0 = new JTextArea();
				panel.add(jt0);
				frame.add(panel, BorderLayout.NORTH);
				JPanel Panel1 = new JPanel();
				Panel1.setLayout(new GridLayout(3, 1));
				JButton jButton = new JButton("�г�ȫ����Ϣ");
				JButton jButton1 = new JButton("��/����������Ա�Ӵ�");
				JButton jButton2 = new JButton("��/����");
				JButton jButton3 = new JButton("��/��У");
				JButton jButton01 = new JButton("��/����������Ա�Ӵ�");
				JButton jButton02 = new JButton("��/����");
				JButton jButton03 = new JButton("��/��У");
				JButton lab1 = new JButton("ĳ����/������");
				JButton lab01 = new JButton("ĳ����/������");
				JTextField jt1 = new JTextField();

				JLabel lab2 = new JLabel("ѧ�ţ�", Label.LEFT);
				JTextField jt2 = new JTextField();
				JLabel lab3 = new JLabel("ѧԺ��", Label.LEFT);
				JTextField jt3 = new JTextField();
				JLabel lab4 = new JLabel("���ڵأ�", Label.LEFT);
				JTextField jt4 = new JTextField();

				JLabel lab6 = new JLabel("���������ڣ�", Label.LEFT);
				JTextField jt6 = new JTextField();
				JTextField jt7 = new JTextField();
				JLabel kb2 = new JLabel("");
				JLabel kb3 = new JLabel("");
				JButton jButton4 = new JButton("����exl�ļ�");

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

				// �г�ȫ����Ϣ
				jButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						jt0.setText(null);
						File f = new File("E:\\test.xls");
						// �ļ�λ��E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // ��õ�һ�����������

							for (int i = 0; i < sheet.getRows(); i++) {
								for (int j = 0; j < sheet.getColumns(); j++) {
									Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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

				// ��/����������Ա�Ӵ����ǣ�
				jButton1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						jt0.setText(null);
						jButton1.setVisible(false);
						jButton01.setVisible(true);
						File f = new File("E:\\test.xls");
						// �ļ�λ��E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // ��õ�һ�����������
							x = sheet.getRows() - 1;
							y = 0;
							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(4, i).getContents().equals("��")) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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
						// ������״ͼ

						Test();
						JFrame frame = new JFrame("�����ݵ�����ͳ��");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Demo().getChartPanel()); // �������ͼ
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);

					}
				});

				// ��/���ȣ��ǣ�
				jButton2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						jt0.setText(null);
						jButton2.setVisible(false);
						jButton02.setVisible(true);
						File f = new File("E:\\test.xls");
						// �ļ�λ��E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // ��õ�һ�����������
							x = sheet.getRows() - 1;
							y = 0;
							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(5, i).getContents().equals("��")) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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
						// ������״ͼ

						Test();
						JFrame frame = new JFrame("�����ݵ�����ͳ��");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Demo().getChartPanel()); // �������ͼ
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);

					}
				});

				// ��/��У���ǣ�
				jButton3.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						jt0.setText(null);
						jButton3.setVisible(false);
						jButton03.setVisible(true);
						File f = new File("E:\\test.xls");
						// �ļ�λ��E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // ��õ�һ�����������
							x = sheet.getRows() - 1;
							y = 0;
							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(6, i).getContents().equals("��")) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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

						// ������״ͼ
						Test();
						JFrame frame = new JFrame("�����ݵ�����ͳ��");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Demo().getChartPanel()); // �������ͼ
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);

					}
				});

				// ��/����������Ա�Ӵ�����
				jButton01.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						jt0.setText(null);
						jButton1.setVisible(true);
						jButton01.setVisible(false);
						File f = new File("E:\\test.xls");
						// �ļ�λ��E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // ��õ�һ�����������
							x = sheet.getRows() - 1;
							n = 0;
							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(4, i).getContents().equals("��")) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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
						// ������״ͼ

						Test();
						JFrame frame = new JFrame("�����ݵ�����ͳ��");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Demo().getChartPanel()); // �������ͼ
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);

					}
				});

				// ��/���ȣ���
				jButton02.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						jt0.setText(null);
						jButton2.setVisible(true);
						jButton02.setVisible(false);
						File f = new File("E:\\test.xls");
						// �ļ�λ��E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // ��õ�һ�����������
							x = sheet.getRows() - 1;
							n = 0;
							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(5, i).getContents().equals("��")) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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
						// ������״ͼ

						Test();
						JFrame frame = new JFrame("�����ݵ�����ͳ��");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Demo().getChartPanel()); // �������ͼ
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);

					}
				});

				// ��/��У����
				jButton03.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						jt0.setText(null);
						jButton3.setVisible(true);
						jButton03.setVisible(false);
						File f = new File("E:\\test.xls");
						// �ļ�λ��E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // ��õ�һ�����������
							x = sheet.getRows() - 1;
							n = 0;
							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(6, i).getContents().equals("��")) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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

						// ������״ͼ
						Test();
						JFrame frame = new JFrame("�����ݵ�����ͳ��");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Demo().getChartPanel()); // �������ͼ
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);

					}
				});

				// ĳ����/���������ǣ�
				lab1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						jt0.setText(null);
						lab01.setVisible(true);
						lab1.setVisible(false);
						File f = new File("E:\\test.xls");
						File f1 = new File("E:\\��Ա��Ϣ.xls");
						// �ļ�λ��E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // ��õ�һ�����������
							Workbook book1 = Workbook.getWorkbook(f1);
							Sheet sheet1 = book1.getSheet(0); // ��õ�һ�����������
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
										Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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
						// ������״ͼ
						Test();
						JFrame frame = new JFrame("�����ݵ�����ͳ��");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Demo().getChartPanel()); // �������ͼ
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					}
				});

				// ĳ����/����������
				lab01.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						jt0.setText(null);
						lab1.setVisible(true);
						lab01.setVisible(false);
						File f = new File("E:\\test.xls");
						File f1 = new File("E:\\��Ա��Ϣ.xls");
						// �ļ�λ��E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // ��õ�һ�����������
							Workbook book1 = Workbook.getWorkbook(f1);
							Sheet sheet1 = book1.getSheet(0); // ��õ�һ�����������
							x = sheet1.getRows();
							n = 0;
							int l[] = new int[x];
							jt0.setText("δ��д��Ա" + "\n");
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
						// ������״ͼ
						Test();
						JFrame frame = new JFrame("�����ݵ�����ͳ��");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Demo().getChartPanel()); // �������ͼ
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					}
				});

				// ������/���ڲ�ѯ��������
				jt6.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						jt0.setText(null);
						File f = new File("E:\\test.xls");
						// �ļ�λ��E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // ��õ�һ�����������

							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							if (jt7.getText().equals("")) {
								for (int i = 0; i < sheet.getRows(); i++) {
									if (sheet.getCell(0, i).getContents().equals(jt6.getText())) {
										for (int j = 0; j < sheet.getColumns(); j++) {
											Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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
											Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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
				// ������/���ڲ�ѯ�����ڣ�
				jt7.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						jt0.setText(null);
						File f = new File("E:\\test.xls");
						// �ļ�λ��E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // ��õ�һ�����������

							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							if (jt6.getText().equals("")) {
								for (int i = 0; i < sheet.getRows(); i++) {
									if (sheet.getCell(7, i).getContents().equals(jt7.getText())) {
										for (int j = 0; j < sheet.getColumns(); j++) {
											Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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
											Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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

				// ��ѧ�Ų�ѯ
				jt2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						jt0.setText(null);
						File f = new File("E:\\test.xls");
						// �ļ�λ��E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // ��õ�һ�����������

							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(1, i).getContents().equals(jt2.getText())) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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

				// ��ѧԺ��ѯ
				jt3.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						jt0.setText(null);
						File f = new File("E:\\test.xls");
						// �ļ�λ��E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // ��õ�һ�����������

							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(2, i).getContents().equals(jt3.getText())) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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

				// �����ڵز�ѯ
				jt4.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						jt0.setText(null);
						File f = new File("E:\\test.xls");
						// �ļ�λ��E:\\test.xls
						try {
							Workbook book = Workbook.getWorkbook(f);
							Sheet sheet = book.getSheet(0); // ��õ�һ�����������

							for (int j = 0; j < sheet.getColumns(); j++) {
								Cell cell = sheet.getCell(j, 0);
								jt0.setText(jt0.getText() + cell.getContents() + " ");
							}
							jt0.setText(jt0.getText() + "\n");
							for (int i = 0; i < sheet.getRows(); i++) {
								if (sheet.getCell(3, i).getContents().equals(jt4.getText())) {
									for (int j = 0; j < sheet.getColumns(); j++) {
										Cell cell = sheet.getCell(j, i); // ��õ�Ԫ��
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

				// ����xls��
				jButton4.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						jt0.setText(null);
						FileInputStream fis;
						try {
							fis = new FileInputStream("E:/test.xls");
							FileOutputStream fos = new FileOutputStream("E:/������Ϣ.xls");
							byte[] bs = new byte[1024];
							int len = -1;
							while ((len = fis.read(bs)) != -1) {
								fos.write(bs, 0, len);
							}
							fos.close();
							fis.close();
						} catch (FileNotFoundException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}

					}
				});

			}
		});

	}

	// ������״ͼ
	private static void Test() {
		// TODO �Զ����ɵķ������
		CategoryDataset dataset = getDataSet();// ����õ����ݴ��ݸ�CategoryDataset��Ķ���
		JFreeChart chart = ChartFactory.createBarChart3D("����ͳ�Ʊ�", // ͼ�����
				"������Ϣ", // Ŀ¼�����ʾ��ǩ
				"����/��", // ��ֵ�����ʾ��ǩ
				dataset, // ���ݼ�
				PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
				true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
				false, // �Ƿ����ɹ���
				false // �Ƿ�����URL����
		);

		CategoryPlot plot = chart.getCategoryPlot();// ��ȡͼ���������
		CategoryAxis domainAxis = plot.getDomainAxis(); // ˮƽ�ײ��б�
		domainAxis.setLabelFont(new Font("����", Font.BOLD, 14)); // ˮƽ�ײ�����
		domainAxis.setTickLabelFont(new Font("����", Font.BOLD, 12)); // ��ֱ����
		ValueAxis rangeAxis = plot.getRangeAxis();// ��ȡ��״
		rangeAxis.setLabelFont(new Font("����", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("����", Font.BOLD, 20));// ���ñ�������

		frame1 = new ChartPanel(chart, true); // ����Ҳ������chartFrame,����ֱ������һ��������Frame

	}

	private static CategoryDataset getDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(y, "��", "��");
		dataset.addValue(n, "��", "��");
		return dataset;
	}

	public ChartPanel getChartPanel() {
		return frame1;

	}

}