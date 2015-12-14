.class Lcom/livemixtapes/library/JSONParser$1$1;
.super Ljava/lang/Object;
.source "JSONParser.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/library/JSONParser$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/livemixtapes/library/JSONParser$1;

.field private final synthetic val$context:Landroid/app/Activity;


# direct methods
.method constructor <init>(Lcom/livemixtapes/library/JSONParser$1;Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/library/JSONParser$1$1;->this$1:Lcom/livemixtapes/library/JSONParser$1;

    iput-object p2, p0, Lcom/livemixtapes/library/JSONParser$1$1;->val$context:Landroid/app/Activity;

    .line 102
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 5
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 105
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 111
    const-string v2, "https://play.google.com/store/apps/details?id=com.livemixtapes"

    .line 113
    .local v2, "url":Ljava/lang/String;
    :try_start_0
    new-instance v1, Landroid/content/Intent;

    const-string v3, "android.intent.action.MAIN"

    invoke-direct {v1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 114
    .local v1, "i":Landroid/content/Intent;
    const-string v3, "com.android.chrome/com.android.chrome.Main"

    invoke-static {v3}, Landroid/content/ComponentName;->unflattenFromString(Ljava/lang/String;)Landroid/content/ComponentName;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 115
    const-string v3, "android.intent.category.LAUNCHER"

    invoke-virtual {v1, v3}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 116
    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 117
    iget-object v3, p0, Lcom/livemixtapes/library/JSONParser$1$1;->val$context:Landroid/app/Activity;

    invoke-virtual {v3, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 127
    :goto_0
    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v3

    invoke-static {v3}, Landroid/os/Process;->killProcess(I)V

    .line 128
    return-void

    .line 119
    .end local v1    # "i":Landroid/content/Intent;
    :catch_0
    move-exception v0

    .line 121
    .local v0, "e":Landroid/content/ActivityNotFoundException;
    new-instance v1, Landroid/content/Intent;

    const-string v3, "android.intent.action.VIEW"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-direct {v1, v3, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 122
    .restart local v1    # "i":Landroid/content/Intent;
    iget-object v3, p0, Lcom/livemixtapes/library/JSONParser$1$1;->val$context:Landroid/app/Activity;

    invoke-virtual {v3, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method
