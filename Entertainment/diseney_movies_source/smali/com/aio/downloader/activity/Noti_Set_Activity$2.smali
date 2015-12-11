.class Lcom/aio/downloader/activity/Noti_Set_Activity$2;
.super Ljava/lang/Object;
.source "Noti_Set_Activity.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/Noti_Set_Activity;->click()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/Noti_Set_Activity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/Noti_Set_Activity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/Noti_Set_Activity$2;->this$0:Lcom/aio/downloader/activity/Noti_Set_Activity;

    .line 151
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 4
    .param p1, "arg0"    # Landroid/widget/CompoundButton;
    .param p2, "arg1"    # Z

    .prologue
    .line 157
    if-eqz p2, :cond_0

    .line 158
    iget-object v1, p0, Lcom/aio/downloader/activity/Noti_Set_Activity$2;->this$0:Lcom/aio/downloader/activity/Noti_Set_Activity;

    # getter for: Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_b_low:Landroid/content/SharedPreferences;
    invoke-static {v1}, Lcom/aio/downloader/activity/Noti_Set_Activity;->access$1(Lcom/aio/downloader/activity/Noti_Set_Activity;)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "b_low"

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 159
    new-instance v0, Landroid/content/Intent;

    const-string v1, "toggle_on"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 160
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/activity/Noti_Set_Activity$2;->this$0:Lcom/aio/downloader/activity/Noti_Set_Activity;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/activity/Noti_Set_Activity;->sendBroadcast(Landroid/content/Intent;)V

    .line 166
    :goto_0
    return-void

    .line 162
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/activity/Noti_Set_Activity$2;->this$0:Lcom/aio/downloader/activity/Noti_Set_Activity;

    # getter for: Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_b_low:Landroid/content/SharedPreferences;
    invoke-static {v1}, Lcom/aio/downloader/activity/Noti_Set_Activity;->access$1(Lcom/aio/downloader/activity/Noti_Set_Activity;)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "b_low"

    const/4 v3, 0x1

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 163
    new-instance v0, Landroid/content/Intent;

    const-string v1, "toggle_off"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 164
    .restart local v0    # "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/activity/Noti_Set_Activity$2;->this$0:Lcom/aio/downloader/activity/Noti_Set_Activity;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/activity/Noti_Set_Activity;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_0
.end method
