import { useState } from "react";
import { useNavigate } from "react-router-dom";

export function FormSignUp() {

    const navigate = useNavigate();

    const [email, setEmail] = useState();
    const [senha, setSenha] = useState();

    return (
        <div className="flex flex-col text-left items-center ">
            <form action="" className="w-1/3">
                <fieldset className="flex flex-col gap-4 text-3xl [font-family:'Inter-Regular',Helvetica]">
                    <legend className="flex items-center my-8">Crie sua conta</legend>

                    <label htmlFor="name" className="text-gray-500 text-2xl">Nome</label>
                    <input type="text"
                        id="name"
                        required
                        placeholder="Digite seu nome"
                        onChange={() => setEmail}
                        className="border rounded-md text-xl h-12 px-5" />

                    <label htmlFor="email" className="text-gray-500 text-2xl">E-mail</label>
                    <input type="email"
                        id="email"
                        required
                        placeholder="Digite seu e-mail"
                        className="border rounded-md text-xl h-12 px-5" />

                    <label htmlFor="userName" className="text-gray-500 text-2xl">Username</label>
                    <input type="text"
                        id="userName"
                        required
                        placeholder="@seu_username"
                        className="border rounded-md text-xl h-12 px-5" />

                    <label htmlFor="descricao" className="text-gray-500 text-2xl">Descrição</label>
                    <input type="text"
                        id="descricao"
                        required
                        placeholder="Faça uma descrição"
                        className="border rounded-md text-xl h-12 px-5" />

                    <label htmlFor="numbe" className="text-gray-500 text-2xl">Celular</label>
                    <input type="tel"
                        id="number"
                        required
                        placeholder="Digite seu número de celular"
                        className="border rounded-md text-xl h-12 px-5" />

                    <label className="text-gray-500 text-2xl">Senha</label>
                    <input type="password" id="password"
                        required
                        className="border rounded-md text-xl h-12 px-5"
                         placeholder="Digite sua Senha" />

                    <button onClick={() => navigate(``)} className="bg-[#f37671] border rounded-lg  text-white h-14"><input type="submit" value="Entrar" /></button>
                </fieldset>
                <div>
                    <p className="flex justify-center my-5 [font-family:'Inter-Bold',Helvetica]">Já possui conta? <button onClick={() => navigate(`/`)} className="text-[#f37671] underline"> Entrar</button></p>
                </div>
            </form>
        </div>
    )
}