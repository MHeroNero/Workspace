/*
 * WelcomeView.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import sever.Client;

import model.Baname;
import model.Greattext;
import model.User;
import model.Tietext;

/**
 *
 * @author  __USER__
 */
public class WelcomeView extends javax.swing.JFrame {
	private User u;
	private Tietext t;
	private Baname b;

	/** Creates new form WelcomeView */
	public WelcomeView(User u, Baname b) {
		this.u = u;
		this.t = t;
		this.b = b;

		initComponents();
		try {
			loadtext();
			loadtext2();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setTitle("行吧");
		this.jLabel3.setText(u.getName());
		this.jLabel1.setText(b.getBaname());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		this.jLabel2.setText(df.format(new Date()));// new Date()为获取当前系统时间
	}

	void loadtext() throws UnknownHostException, IOException,
			ClassNotFoundException {
		Tietext t = new Tietext(null, null, null, null);
		String whichba = b.getBaname();
		ArrayList<Tietext> tietexts = t.viewDate(whichba);
		Object title[] = { "标题", "写作用户" };
		Object detail[][] = new Object[tietexts.size()][2];
		for (int i = 0; i < tietexts.size(); i++) {
			detail[i][0] = tietexts.get(i).getTitle();
			detail[i][1] = tietexts.get(i).getWriter();
		}
		this.jTable1.setModel(new DefaultTableModel(detail, title));
	}

	void loadtext2() throws UnknownHostException, IOException,
			ClassNotFoundException {
		String whichba = b.getBaname();
		Greattext gt = new Greattext(null, null, null);
		ArrayList<Greattext> tietexts = gt.viewDate(whichba);
		Object title[] = { "标题", "写作用户" };
		Object detail[][] = new Object[tietexts.size()][2];
		for (int i = 0; i < tietexts.size(); i++) {
			detail[i][0] = tietexts.get(i).getGreattext();
			detail[i][1] = tietexts.get(i).getName();
		}
		this.jTable2.setModel(new DefaultTableModel(detail, title));
	}

	void qiandao() {
		try {
			String username = u.getName();
			String nowtime = this.jLabel2.getText();
			int i = 0;
			Client c = new Client();
			i = c.qiandao(nowtime, username);
			this.jLabel4.setText(String.valueOf(i));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel5 = new javax.swing.JPanel();
		jPanel4 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jButton6 = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jButton7 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jTextField2 = new javax.swing.JTextField();
		jButton9 = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new java.awt.Dimension(1000, 1000));

		jPanel5.setBackground(new java.awt.Color(255, 255, 255));

		jPanel4.setBackground(new java.awt.Color(0, 153, 204));

		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/标志.png"))); // NOI18N
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jButton2.setText("\u4e2a\u4eba\u7a7a\u95f4");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton2ActionPerformed(evt);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jLabel3.setText("jLabel3");

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout
				.setHorizontalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel4Layout
										.createSequentialGroup()
										.addGap(71, 71, 71)
										.addComponent(
												jButton1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												112,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												699, Short.MAX_VALUE)
										.addComponent(jLabel3).addGap(18, 18,
												18).addComponent(jButton2)
										.addGap(52, 52, 52)));
		jPanel4Layout
				.setVerticalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jButton1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																110,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																jPanel4Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jButton2)
																		.addComponent(
																				jLabel3)))
										.addContainerGap(18, Short.MAX_VALUE)));

		jLabel1.setFont(new java.awt.Font("宋体", 0, 36));
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("XX\u5427");

		jButton6.setText("\u7b7e\u5230");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jLabel2.setText("xx\u6708xx\u65e5");

		jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
		jTabbedPane1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTable1MouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(jTable1);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addComponent(
						jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
						844, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589,
				Short.MAX_VALUE));

		jTabbedPane1.addTab("\u770b\u5e16", jPanel1);

		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTable2MouseClicked(evt);
			}
		});
		jScrollPane2.setViewportView(jTable2);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 852,
				Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 589,
				Short.MAX_VALUE));

		jTabbedPane1.addTab("\u7cbe\u54c1", jPanel2);

		jButton7.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jButton7.setText("\u53d1\u5e03\u5e16\u5b50");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jButton3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jButton3.setText("\u8fdb\u5165\u5176\u4ed6\u5427");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jTextField2.setEditable(false);
		jTextField2.setText(" ");

		jButton9.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jButton9.setText("\u67e5\u770b\u5e16\u5b50");
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton9ActionPerformed(evt);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout
				.setHorizontalGroup(jPanel5Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel4,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGroup(
								jPanel5Layout
										.createSequentialGroup()
										.addGap(192, 192, 192)
										.addComponent(jLabel1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												536, Short.MAX_VALUE)
										.addComponent(jButton6)
										.addGap(8, 8, 8)
										.addComponent(
												jLabel4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												112,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(
												jLabel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												72,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(36, 36, 36))
						.addGroup(
								jPanel5Layout
										.createSequentialGroup()
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addGroup(
																jPanel5Layout
																		.createSequentialGroup()
																		.addGap(
																				157,
																				157,
																				157)
																		.addComponent(
																				jButton7)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton3)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jTextField2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				247,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton9))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																jPanel5Layout
																		.createSequentialGroup()
																		.addGap(
																				89,
																				89,
																				89)
																		.addComponent(
																				jTabbedPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				909,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(111, Short.MAX_VALUE)));
		jPanel5Layout
				.setVerticalGroup(jPanel5Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel5Layout
										.createSequentialGroup()
										.addComponent(
												jPanel4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(122, 122, 122)
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jLabel1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																31,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																jPanel5Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jButton6)
																		.addComponent(
																				jLabel2)
																		.addComponent(
																				jLabel4,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				24,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(37, 37, 37)
										.addComponent(
												jTabbedPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												594,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton9)
														.addComponent(
																jTextField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton7)
														.addComponent(jButton3))
										.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1007,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		qiandao();
	}

	private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int selRow = this.jTable1.getSelectedRow();
		this.jTextField2.setText(this.jTable1.getValueAt(selRow, 0).toString()
				.trim());
	}

	private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int selRow = this.jTable2.getSelectedRow();
		this.jTextField2.setText(this.jTable2.getValueAt(selRow, 0).toString()
				.trim());
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt)
			throws UnknownHostException, IOException {
		// TODO add your handling code here:
		if (this.jTextField2.equals("")) {
			JOptionPane.showMessageDialog(null, "请选择要查看的帖子!");
		} else {
			String title = this.jTextField2.getText();
			Client c = new Client();
			try {
				Tietext t = c.readtext(title);
				if (t == null)
					JOptionPane.showMessageDialog(this, "文章不存在");
				else {
					new PostView(t, u, b).setVisible(true);
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		new XingbaView(u).setVisible(true);
		this.dispose();
	}

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		new PostingView(t, u, b).setVisible(true);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
			throws UnknownHostException, IOException {
		Client c = new Client();
		String name = u.getName();
		String baname = b.getBaname();
		int i = 0;
		i = c.bazhulogin(name, baname);
		if (i == 1) {
			new BZView(u, b).setVisible(true);
		} else {
			new YHView(u, b).setVisible(true);
		}
	}

	/**
	 * @param args the command line arguments  main
	 */

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton9;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JTextField jTextField2;
	// End of variables declaration//GEN-END:variables

}