package com.alura.literalura.repository;

import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Idioma;
import com.alura.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findByTituloContainsIgnoreCase(String titulo);

//    List<Libro> findTop5ByOrderByEvaluacionDesc();
    List<Libro> findByIdioma(Idioma idioma);
//  List<Libro> findByTotalTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(int totalTemporadas, Double evaluacion);

//    @Query("SELECT s FROM Libro s WHERE s.totalTemporadas <= :totalTemporadas AND s.evaluacion >= :evaluacion")
//    List<Libro> seriesPorTemporadaYEvaluacion(int totalTemporadas, Double evaluacion);
//
//    @Query("SELECT e FROM Libro s JOIN s.episodios e WHERE e.titulo ILIKE %:nombreAutor%")
//    List<Autor> episodiosPorNombre(String nombreAutor);
//
//    @Query("SELECT e FROM Libro s JOIN s.episodios e WHERE s = :serie ORDER BY e.evaluacion DESC LIMIT 5")
//    List<Autor> top5Autors(Libro serie);
//
//    @Query("SELECT s FROM Libro s " + "JOIN s.episodios e" + " GROUP BY s " + "ORDER BY MAX(e.fechaDeLanzamiento) DESC LIMIT 5")
//    List<Libro> lanzamientosMasRecientes();
//
//    @Query("SELECT e FROM Libro s JOIN s.episodios e WHERE s.id = :id AND e.temporada = :numeroTemporada")
//    List<Autor> obtenerTemporadasPorNumero(Long id, Long numeroTemporada);
}
