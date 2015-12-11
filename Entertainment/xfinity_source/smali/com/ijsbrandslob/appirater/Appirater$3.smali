.class Lcom/ijsbrandslob/appirater/Appirater$3;
.super Ljava/lang/Object;
.source "Appirater.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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

.field final synthetic val$internalRateDialog:Landroid/app/Dialog;


# direct methods
.method constructor <init>(Lcom/ijsbrandslob/appirater/Appirater;Landroid/app/Dialog;)V
    .locals 0
    .param p1, "this$0"    # Lcom/ijsbrandslob/appirater/Appirater;

    .prologue
    .line 227
    iput-object p1, p0, Lcom/ijsbrandslob/appirater/Appirater$3;->this$0:Lcom/ijsbrandslob/appirater/Appirater;

    iput-object p2, p0, Lcom/ijsbrandslob/appirater/Appirater$3;->val$internalRateDialog:Landroid/app/Dialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 230
    iget-object v0, p0, Lcom/ijsbrandslob/appirater/Appirater$3;->this$0:Lcom/ijsbrandslob/appirater/Appirater;

    const/4 v1, 0x1

    # setter for: Lcom/ijsbrandslob/appirater/Appirater;->mDeclinedToRate:Z
    invoke-static {v0, v1}, Lcom/ijsbrandslob/appirater/Appirater;->access$602(Lcom/ijsbrandslob/appirater/Appirater;Z)Z

    .line 231
    iget-object v0, p0, Lcom/ijsbrandslob/appirater/Appirater$3;->this$0:Lcom/ijsbrandslob/appirater/Appirater;

    # invokes: Lcom/ijsbrandslob/appirater/Appirater;->saveSettings()V
    invoke-static {v0}, Lcom/ijsbrandslob/appirater/Appirater;->access$300(Lcom/ijsbrandslob/appirater/Appirater;)V

    .line 232
    iget-object v0, p0, Lcom/ijsbrandslob/appirater/Appirater$3;->val$internalRateDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    .line 233
    return-void
.end method
