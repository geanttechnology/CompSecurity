.class Lcom/ijsbrandslob/appirater/Appirater$2;
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
    .line 209
    iput-object p1, p0, Lcom/ijsbrandslob/appirater/Appirater$2;->this$0:Lcom/ijsbrandslob/appirater/Appirater;

    iput-object p2, p0, Lcom/ijsbrandslob/appirater/Appirater$2;->val$internalRateDialog:Landroid/app/Dialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 212
    iget-object v1, p0, Lcom/ijsbrandslob/appirater/Appirater$2;->this$0:Lcom/ijsbrandslob/appirater/Appirater;

    # getter for: Lcom/ijsbrandslob/appirater/Appirater;->isDebuggable:Z
    invoke-static {v1}, Lcom/ijsbrandslob/appirater/Appirater;->access$400(Lcom/ijsbrandslob/appirater/Appirater;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 214
    iget-object v1, p0, Lcom/ijsbrandslob/appirater/Appirater$2;->this$0:Lcom/ijsbrandslob/appirater/Appirater;

    new-instance v2, Ljava/util/Date;

    invoke-direct {v2}, Ljava/util/Date;-><init>()V

    # setter for: Lcom/ijsbrandslob/appirater/Appirater;->mReminderRequestDate:Ljava/util/Date;
    invoke-static {v1, v2}, Lcom/ijsbrandslob/appirater/Appirater;->access$502(Lcom/ijsbrandslob/appirater/Appirater;Ljava/util/Date;)Ljava/util/Date;

    .line 222
    :goto_0
    iget-object v1, p0, Lcom/ijsbrandslob/appirater/Appirater$2;->this$0:Lcom/ijsbrandslob/appirater/Appirater;

    # invokes: Lcom/ijsbrandslob/appirater/Appirater;->saveSettings()V
    invoke-static {v1}, Lcom/ijsbrandslob/appirater/Appirater;->access$300(Lcom/ijsbrandslob/appirater/Appirater;)V

    .line 223
    iget-object v1, p0, Lcom/ijsbrandslob/appirater/Appirater$2;->val$internalRateDialog:Landroid/app/Dialog;

    invoke-virtual {v1}, Landroid/app/Dialog;->dismiss()V

    .line 224
    return-void

    .line 217
    :cond_0
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 218
    .local v0, "c":Ljava/util/Calendar;
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0, v1}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    .line 219
    const/4 v1, 0x5

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/Calendar;->add(II)V

    .line 220
    iget-object v1, p0, Lcom/ijsbrandslob/appirater/Appirater$2;->this$0:Lcom/ijsbrandslob/appirater/Appirater;

    invoke-virtual {v0}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v2

    # setter for: Lcom/ijsbrandslob/appirater/Appirater;->mReminderRequestDate:Ljava/util/Date;
    invoke-static {v1, v2}, Lcom/ijsbrandslob/appirater/Appirater;->access$502(Lcom/ijsbrandslob/appirater/Appirater;Ljava/util/Date;)Ljava/util/Date;

    goto :goto_0
.end method
