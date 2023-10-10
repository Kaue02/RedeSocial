import { useState } from "react";
import { useNavigate } from "react-router-dom";

export function FormLogin() {

    const navigate = useNavigate();

    const [email, setEmail] = useState();
    const [senha, setSenha] = useState();


    return (
        <div className="flex flex-col text-left items-center ">
            <form action="" >
                <fieldset className="flex flex-col gap-2 text-3xl [font-family:'Inter-Regular',Helvetica]">
                    <legend className="flex items-center my-8">Faça seu login</legend>

                    <label htmlFor="email" className="text-gray-500 text-2xl">E-mail</label>
                    <input type="email"
                        id="email"
                        onChange={() => setEmail}
                        required
                        placeholder="Digite seu e-mail"
                        className="border rounded-md text-xl h-12 " />

                    <label className="text-gray-500 text-2xl">Senha</label>
                    <input type="password" id="password"
                        onChange={() => setSenha}
                        required
                        className="border rounded-md text-xl h-12" placeholder="Digite sua Senha" />

                    <div className=" flex items-center">
                        <input
                            type="checkbox"
                            id="rememberPassword"
                            className="mr-2 h-4 w-4 text-white " />
                        <label htmlFor="rememberPassword" className="text-gray-700 text-lg">Lembra senha  </label>
                        <button className="text-gray-500 underline text-lg ml-12"> Esqueci minha senha</button>
                    </div>

                    <button className="bg-[#f37671] border rounded-lg  text-white h-14" onClick={() => navigate(`/Home${email}`)}><input type="submit" value="Entrar" /></button>
                </fieldset>
                <div>
                    <p className="flex justify-center my-5 [font-family:'Inter-Bold',Helvetica]">Não possui conta? <button onClick={() => navigate(`/SignUp`)} className="text-[#f37671] underline"> Cadastre-se</button></p>
                </div>
            </form>
        </div>
    )
}