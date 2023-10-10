import { FormLogin } from "../components/FormLogin";

export function Login() {
    return (
        <div className="grid grid-cols-2 h-screen w-screen m-0 ">
            <div className="flex flex-col mt-32 text-center gap-16 h-screen [font-family:'Inter-SemiBold',Helvetica]" >
                <div className="flex justify-center gap-3 ">
                    <img className="h-16" src="./Logo.svg" alt="" />
                    <h1 className="text-6xl">Techgram</h1>
                </div>
                <div className="flex flex-col justify-center">
                    <FormLogin />
                </div>
            </div>
            <div className="flex justify-end my-0 ">
                <img className=" col-span-1" src="./fundo.png" alt="" />
            </div>
        </div>
    )
}