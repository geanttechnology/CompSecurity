.class Lcom/livemixtapes/MainActivity$2;
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
    iput-object p1, p0, Lcom/livemixtapes/MainActivity$2;->this$0:Lcom/livemixtapes/MainActivity;

    .line 132
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 136
    :try_start_0
    sget-boolean v0, Lcom/livemixtapes/MainActivity;->isPlaying:Z

    if-eqz v0, :cond_0

    .line 137
    const/4 v0, 0x1

    sput-boolean v0, Lcom/livemixtapes/MainActivity;->fromWidget:Z

    .line 138
    iget-object v0, p0, Lcom/livemixtapes/MainActivity$2;->this$0:Lcom/livemixtapes/MainActivity;

    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/livemixtapes/MainActivity$2;->this$0:Lcom/livemixtapes/MainActivity;

    .line 139
    const-class v3, Lcom/livemixtapes/NowPlayingActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 138
    invoke-virtual {v0, v1}, Lcom/livemixtapes/MainActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 143
    :cond_0
    :goto_0
    return-void

    .line 141
    :catch_0
    move-exception v0

    goto :goto_0
.end method
