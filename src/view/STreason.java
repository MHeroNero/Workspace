/*
 * STreason.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import sever.Client;

import model.Tietext;

/**
 *
 * @author  __USER__
 */
public class STreason extends javax.swing.JFrame {

	/** Creates new form STreason */
	public STreason() {
		initComponents();
		try {
			loadtext();
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
	}

	void loadtext() throws UnknownHostException, IOException,
			ClassNotFoundException {
		Tietext t = new Tietext(null, null, null, null);
		ArrayList<Tietext> tietexts = t.viewDate2();
		Object title[] = { "标题", "写作用户", "所属贴吧" };
		Object detail[][] = new Object[tietexts.size()][3];
		for (int i = 0; i < tietexts.size(); i++) {
			detail[i][0] = tietexts.get(i).getTitle();
			detail[i][1] = tietexts.get(i).getWriter();
			detail[i][2] = tietexts.get(i).getWhichba();
		}
		this.jTable1.setModel(new DefaultTableModel(detail, title));
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jLabel3 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jButton1 = new javax.swing.JButton();

		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new java.awt.Dimension(500, 450));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jLabel3.setText("\u6240\u5c5e\u7684\u5427");

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jLabel1.setText("\u5f53\u524d\u9009\u62e9\u7684\u7528\u6237\u662f");

		jTextField3.setBackground(new java.awt.Color(255, 255, 255));
		jTextField3.setEditable(false);

		jTextField1.setBackground(new java.awt.Color(255, 255, 255));
		jTextField1.setEditable(false);

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jLabel2.setText("\u5220\u9664\u7684\u5e16\u5b50");

		jTextField2.setBackground(new java.awt.Color(255, 255, 255));
		jTextField2.setEditable(false);

		jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jLabel4.setText("\u7406\u7531");

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane2.setViewportView(jTextArea1);

		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jButton1.setText("\u5220\u9664");
		jButton1.setActionCommand("jButton1");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton1ActionPerformed(evt);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 773,
								Short.MAX_VALUE)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jButton1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								82,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGap(
																												144,
																												144,
																												144)
																										.addComponent(
																												jLabel4)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jScrollPane2,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												525,
																												Short.MAX_VALUE))))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				36,
																				36,
																				36)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jLabel2)
																						.addComponent(
																								jLabel1))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jTextField1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												174,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(
																												50,
																												50,
																												50)
																										.addComponent(
																												jLabel3)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField3,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												223,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								jTextField2))))
										.addGap(62, 62, 62)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												235,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(36, 36, 36)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabel1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																30,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel3)
														.addComponent(
																jTextField3,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																30,
																Short.MAX_VALUE))
										.addGap(27, 27, 27)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																jTextField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																30,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(26, 26, 26)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				142,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				42,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(jLabel4))
										.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
			throws UnknownHostException, IOException {
		// TODO add your handling code here:
		int selectedRow = jTable1.getSelectedRow();
		if (selectedRow < 0) {
			JOptionPane.showMessageDialog(null, "请选择要删除的帖子!");
		} else {
			String title = this.jTextField2.getText();
			String writer = this.jTextField1.getText();
			String screason = this.jTextArea1.getText();
			Client c = new Client();
			c.deletetext(writer, title, screason);
			JOptionPane.showMessageDialog(null, "删除成功");
			try {
				loadtext();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int selRow = this.jTable1.getSelectedRow();
		this.jTextField2.setText(this.jTable1.getValueAt(selRow, 0).toString()
				.trim());
		this.jTextField1.setText(this.jTable1.getValueAt(selRow, 1).toString()
				.trim());
		this.jTextField3.setText(this.jTable1.getValueAt(selRow, 2).toString()
				.trim());

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new STreason().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	// End of variables declaration//GEN-END:variables

}