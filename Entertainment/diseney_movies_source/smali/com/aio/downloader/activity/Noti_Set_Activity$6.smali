.class Lcom/aio/downloader/activity/Noti_Set_Activity$6;
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
    iput-object p1, p0, Lcom/aio/downloader/activity/Noti_Set_Activity$6;->this$0:Lcom/aio/downloader/activity/Noti_Set_Activity;

    .line 209
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 3
    .param p1, "arg0"    # Landroid/widget/CompoundButton;
    .param p2, "arg1"    # Z

    .prologue
    .line 215
    if-eqz p2, :cond_0

    .line 216
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity$6;->this$0:Lcom/aio/downloader/activity/Noti_Set_Activity;

    # getter for: Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_storage:Landroid/content/SharedPreferences;
    invoke-static {v0}, Lcom/aio/downloader/activity/Noti_Set_Activity;->access$5(Lcom/aio/downloader/activity/Noti_Set_Activity;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "wycand"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 217
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 222
    :goto_0
    return-void

    .line 219
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity$6;->this$0:Lcom/aio/downloader/activity/Noti_Set_Activity;

    # getter for: Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_storage:Landroid/content/SharedPreferences;
    invoke-static {v0}, Lcom/aio/downloader/activity/Noti_Set_Activity;->access$5(Lcom/aio/downloader/activity/Noti_Set_Activity;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "wycand"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 220
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_0
.end method
