<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="maison.*" %>

<div class="content-wrapper">
    <div class="row pt-5">
        <div class="col-md-offset-3 col-md-6">
            <div class="box-fiche">
                <div class="box">
                    <div class="card-header bg-primary text-white text-center">
                        <!-- Début du formulaire stylisé -->
                        <div class="card shadow-lg w-100">
                            <div class="card-header bg-primary text-white text-center">
                                <h3 class="mb-3">Login</h3>
                            </div>
                            <div class="card-body p-4">
                                <form action="module.jsp?but=impot.jsp" method="POST">
                                    <div class="form-group">
                                        <label for="username" class="font-weight-bold">Nom d'utilisateur</label>
                                        <input type="text" class="form-control" id="username" name="username" placeholder="Entrez votre nom d'utilisateur" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="password" class="font-weight-bold">Mot de passe</label>
                                        <input type="password" class="form-control" id="password" name="password" placeholder="Entrez votre mot de passe" required>
                                    </div>
                                    <% 
                                        String errorMessage = request.getParameter("error");
                                        if (errorMessage != null) {
                                    %>
                                        <div class="alert alert-danger text-center mt-3" role="alert">
                                            <%= errorMessage %>
                                        </div>
                                    <% } %>
                                    <button type="submit" class="btn btn-primary btn-block mt-4">Se connecter</button>
                                </form>
                            </div>
                            <div class="card-footer text-center text-muted">
                                <small>© 2025 - Votre application</small>
                            </div>
                        </div>
                        <!-- Fin du formulaire stylisé -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
