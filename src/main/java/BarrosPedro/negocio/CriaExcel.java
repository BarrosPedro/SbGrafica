package BarrosPedro.negocio;


  
import excel.*;
import BarrosPedro.negocio.Produto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
  
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
  
public class CriaExcel {
        
       private static final String fileName = "C:/Users/Sb Grafica/Documents/novo2.xls";
  
       public static void main(String[] args) throws IOException {
  
             HSSFWorkbook workbook = new HSSFWorkbook();
             HSSFSheet sheetProdutos = workbook.createSheet("Produtos");
               
             List<Produto> listaProdutos = new ArrayList<Produto>();
             listaProdutos.add(new Produto(1, "Banner 1,80X1", "Adesivo", 0, 0, 0));
                          
               
             int rownum = 0;
             for (Produto produto : listaProdutos) {
                 Row row = sheetProdutos.createRow(rownum++);
                 int cellnum = 0;
                 Cell cellNome = row.createCell(cellnum++);
                 cellNome.setCellValue("código");
                 Cell cellCodigo = row.createCell(cellnum++);
                 cellCodigo.setCellValue(produto.getCodigo());
                 Cell cellDescricao = row.createCell(cellnum++);
                 cellDescricao.setCellValue(produto.getDescricaoUnica());
                 Cell cellTipo = row.createCell(cellnum++);
                 cellTipo.setCellValue(produto.getTipo());
                 Cell cellLargura = row.createCell(cellnum++);
                 cellLargura.setCellValue(produto.getLargura());
                 Cell cellAltura = row.createCell(cellnum++);
                 cellAltura.setCellValue(produto.getAltura());
                 Cell cellValor = row.createCell(cellnum++);
                 cellValor.setCellValue(produto.getValorEntrada());
                                  
             }
               
             try {
                 FileOutputStream out = 
                         new FileOutputStream(new File(CriaExcel.fileName));
                 workbook.write(out);
                 out.close();
                 System.out.println("Arquivo Excel criado com sucesso!");
                   
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
                    System.out.println("Arquivo não encontrado!");
             } catch (IOException e) {
                 e.printStackTrace();
                    System.out.println("Erro na edição do arquivo!");
             }
  
       }
  
}