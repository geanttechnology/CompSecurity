.class Lcom/livemixtapes/MainActivity$5;
.super Landroid/os/AsyncTask;
.source "MainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/MainActivity;


# direct methods
.method constructor <init>(Lcom/livemixtapes/MainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/MainActivity$5;->this$0:Lcom/livemixtapes/MainActivity;

    .line 272
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/MainActivity$5;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 2
    .param p1, "voids"    # [Ljava/lang/Void;

    .prologue
    .line 276
    const-string v0, "generic"

    sget-object v1, Landroid/os/Build;->BRAND:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 277
    iget-object v0, p0, Lcom/livemixtapes/MainActivity$5;->this$0:Lcom/livemixtapes/MainActivity;

    iget-object v1, p0, Lcom/livemixtapes/MainActivity$5;->this$0:Lcom/livemixtapes/MainActivity;

    invoke-virtual {v1}, Lcom/livemixtapes/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    # invokes: Lcom/livemixtapes/MainActivity;->gcm(Landroid/content/Context;)V
    invoke-static {v0, v1}, Lcom/livemixtapes/MainActivity;->access$0(Lcom/livemixtapes/MainActivity;Landroid/content/Context;)V

    .line 278
    :cond_0
    const/4 v0, 0x0

    return-object v0
.end method
