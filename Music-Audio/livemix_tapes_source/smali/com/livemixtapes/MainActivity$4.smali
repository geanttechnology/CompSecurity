.class Lcom/livemixtapes/MainActivity$4;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/widget/TabHost$OnTabChangeListener;


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
    iput-object p1, p0, Lcom/livemixtapes/MainActivity$4;->this$0:Lcom/livemixtapes/MainActivity;

    .line 239
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTabChanged(Ljava/lang/String;)V
    .locals 2
    .param p1, "tabId"    # Ljava/lang/String;

    .prologue
    .line 244
    iget-object v1, p0, Lcom/livemixtapes/MainActivity$4;->this$0:Lcom/livemixtapes/MainActivity;

    invoke-virtual {v1}, Lcom/livemixtapes/MainActivity;->getLocalActivityManager()Landroid/app/LocalActivityManager;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/app/LocalActivityManager;->getActivity(Ljava/lang/String;)Landroid/app/Activity;

    move-result-object v0

    .line 247
    .local v0, "activity":Landroid/app/Activity;
    if-eqz v0, :cond_0

    .line 249
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/Activity;->onWindowFocusChanged(Z)V

    .line 251
    const-string v1, "Profile"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 256
    :cond_0
    return-void
.end method
