.class Lcom/ijsbrandslob/appirater/Appirater$4;
.super Ljava/lang/Object;
.source "Appirater.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/ijsbrandslob/appirater/Appirater;->showRatingAlert(Landroid/app/Activity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/ijsbrandslob/appirater/Appirater;


# direct methods
.method constructor <init>(Lcom/ijsbrandslob/appirater/Appirater;)V
    .locals 0
    .param p1, "this$0"    # Lcom/ijsbrandslob/appirater/Appirater;

    .prologue
    .line 236
    iput-object p1, p0, Lcom/ijsbrandslob/appirater/Appirater$4;->this$0:Lcom/ijsbrandslob/appirater/Appirater;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 239
    iget-object v0, p0, Lcom/ijsbrandslob/appirater/Appirater$4;->this$0:Lcom/ijsbrandslob/appirater/Appirater;

    const/4 v1, 0x1

    # setter for: Lcom/ijsbrandslob/appirater/Appirater;->mDeclinedToRate:Z
    invoke-static {v0, v1}, Lcom/ijsbrandslob/appirater/Appirater;->access$602(Lcom/ijsbrandslob/appirater/Appirater;Z)Z

    .line 240
    iget-object v0, p0, Lcom/ijsbrandslob/appirater/Appirater$4;->this$0:Lcom/ijsbrandslob/appirater/Appirater;

    # invokes: Lcom/ijsbrandslob/appirater/Appirater;->saveSettings()V
    invoke-static {v0}, Lcom/ijsbrandslob/appirater/Appirater;->access$300(Lcom/ijsbrandslob/appirater/Appirater;)V

    .line 241
    return-void
.end method
