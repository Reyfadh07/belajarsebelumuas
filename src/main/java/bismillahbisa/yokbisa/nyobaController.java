/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillahbisa.yokbisa;

import bismillahbisa.yokbisa.exceptions.NonexistentEntityException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author raiha
 */
@Controller
@ResponseBody
public class nyobaController {
    
Nyobaujian2 data = new Nyobaujian2();
    Nyobaujian2JpaController actrl = new Nyobaujian2JpaController();
    
    @RequestMapping ("/getNama/{id}")
    public String getNama(@PathVariable("id") int id){
        
        try 
        {
            data = actrl.findNyobaujian2(id);
            return data.getNama() +"<br>"+ data.getJumlah();
        }
        catch (Exception error)
        {
            return "Data Tidak Diketahui..!";
        }
    }
    
    @RequestMapping ("/delNama/{id}")
    public String delName (@PathVariable("id") int id){
        
        try 
        {
            actrl.destroy(id);
            return "Sukses Menghapus..!";
        }
        catch (NonexistentEntityException error)
        {
            return "Id Tidak Ditemukan";
        }
    }
}
