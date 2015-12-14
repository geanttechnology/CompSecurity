.class Lcom/livemixtapes/MainActivity$3;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/MainActivity;


# direct methods
.method constructor <init>(Lcom/livemixtapes/MainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/MainActivity$3;->this$0:Lcom/livemixtapes/MainActivity;

    .line 150
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 153
    invoke-static {}, Lcom/livemixtapes/User;->logout()V

    .line 155
    :try_start_0
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->stop()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 158
    :goto_0
    iget-object v0, p0, Lcom/livemixtapes/MainActivity$3;->this$0:Lcom/livemixtapes/MainActivity;

    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/livemixtapes/MainActivity$3;->this$0:Lcom/livemixtapes/MainActivity;

    const-class v3, Lcom/livemixtapes/Login;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {v0, v1}, Lcom/livemixtapes/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 159
    return-void

    .line 156
    :catch_0
    move-exception v0

    goto :goto_0
.end method
