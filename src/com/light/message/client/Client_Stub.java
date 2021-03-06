// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.light.message.client;

public final class Client_Stub
    extends java.rmi.server.RemoteStub
    implements com.light.messenger.MessengerClientInf, java.rmi.Remote
{
    private static final long serialVersionUID = 2;
    
    private static java.lang.reflect.Method $method_chatInvite_0;
    private static java.lang.reflect.Method $method_chatLoad_1;
    private static java.lang.reflect.Method $method_getUserList_2;
    private static java.lang.reflect.Method $method_resivefile_3;
    private static java.lang.reflect.Method $method_setChatMsg_4;
    private static java.lang.reflect.Method $method_setMsg_5;
    
    static {
	try {
	    $method_chatInvite_0 = com.light.messenger.MessengerClientInf.class.getMethod("chatInvite", new java.lang.Class[] {int.class, java.lang.String.class, java.lang.String.class, java.util.ArrayList.class, java.util.ArrayList.class});
	    $method_chatLoad_1 = com.light.messenger.MessengerClientInf.class.getMethod("chatLoad", new java.lang.Class[] {int.class});
	    $method_getUserList_2 = com.light.messenger.MessengerClientInf.class.getMethod("getUserList", new java.lang.Class[] {});
	    $method_resivefile_3 = com.light.messenger.MessengerClientInf.class.getMethod("resivefile", new java.lang.Class[] {java.lang.String.class});
	    $method_setChatMsg_4 = com.light.messenger.MessengerClientInf.class.getMethod("setChatMsg", new java.lang.Class[] {java.lang.String.class});
	    $method_setMsg_5 = com.light.messenger.MessengerClientInf.class.getMethod("setMsg", new java.lang.Class[] {java.lang.String.class, java.lang.String.class, java.lang.String.class});
	} catch (java.lang.NoSuchMethodException e) {
	    throw new java.lang.NoSuchMethodError(
		"stub class initialization failed");
	}
    }
    
    // constructors
    public Client_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of chatInvite(int, String, String, ArrayList, ArrayList)
    public void chatInvite(int $param_int_1, java.lang.String $param_String_2, java.lang.String $param_String_3, java.util.ArrayList $param_ArrayList_4, java.util.ArrayList $param_ArrayList_5)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_chatInvite_0, new java.lang.Object[] {new java.lang.Integer($param_int_1), $param_String_2, $param_String_3, $param_ArrayList_4, $param_ArrayList_5}, 1684760234245908930L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of chatLoad(int)
    public void chatLoad(int $param_int_1)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_chatLoad_1, new java.lang.Object[] {new java.lang.Integer($param_int_1)}, -6804691768029262523L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getUserList()
    public void getUserList()
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_getUserList_2, null, -8727215148219979082L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of resivefile(String)
    public void resivefile(java.lang.String $param_String_1)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_resivefile_3, new java.lang.Object[] {$param_String_1}, -3943517829038197582L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of setChatMsg(String)
    public void setChatMsg(java.lang.String $param_String_1)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_setChatMsg_4, new java.lang.Object[] {$param_String_1}, -9083468831735082457L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of setMsg(String, String, String)
    public void setMsg(java.lang.String $param_String_1, java.lang.String $param_String_2, java.lang.String $param_String_3)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_setMsg_5, new java.lang.Object[] {$param_String_1, $param_String_2, $param_String_3}, -8714908731401204375L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}
