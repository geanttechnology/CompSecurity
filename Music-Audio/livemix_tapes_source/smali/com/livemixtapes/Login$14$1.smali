.class Lcom/livemixtapes/Login$14$1;
.super Ljava/lang/Object;
.source "Login.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Login$14;->failure(ILjava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/livemixtapes/Login$14;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Login$14;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Login$14$1;->this$1:Lcom/livemixtapes/Login$14;

    .line 337
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 340
    iget-object v0, p0, Lcom/livemixtapes/Login$14$1;->this$1:Lcom/livemixtapes/Login$14;

    # getter for: Lcom/livemixtapes/Login$14;->this$0:Lcom/livemixtapes/Login;
    invoke-static {v0}, Lcom/livemixtapes/Login$14;->access$0(Lcom/livemixtapes/Login$14;)Lcom/livemixtapes/Login;

    move-result-object v0

    const-string v1, "Error"

    .line 341
    const-string v2, "The given user name or password is invalid."

    .line 340
    # invokes: Lcom/livemixtapes/Login;->showDialog(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v0, v1, v2}, Lcom/livemixtapes/Login;->access$16(Lcom/livemixtapes/Login;Ljava/lang/String;Ljava/lang/String;)V

    .line 342
    return-void
.end method
