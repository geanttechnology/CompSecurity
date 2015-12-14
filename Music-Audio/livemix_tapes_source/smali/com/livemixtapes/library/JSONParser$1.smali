.class Lcom/livemixtapes/library/JSONParser$1;
.super Ljava/lang/Object;
.source "JSONParser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/library/JSONParser;->getJSONFromUrl(Ljava/lang/String;Landroid/app/Activity;)Lorg/json/JSONObject;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/library/JSONParser;

.field private final synthetic val$context:Landroid/app/Activity;


# direct methods
.method constructor <init>(Lcom/livemixtapes/library/JSONParser;Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/library/JSONParser$1;->this$0:Lcom/livemixtapes/library/JSONParser;

    iput-object p2, p0, Lcom/livemixtapes/library/JSONParser$1;->val$context:Landroid/app/Activity;

    .line 97
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 99
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/livemixtapes/library/JSONParser$1;->val$context:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 100
    const-string v1, "App Disabled"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 101
    const-string v1, "This BETA version of LiveMixtapes has been disabled!  Please update your app in the play store to continue to use this app.  You may need to uninstall the app first and then visit http://bit.ly/LMT-Android-BETA and install it again in order to get the latest version quickly."

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 102
    const-string v1, "OK"

    new-instance v2, Lcom/livemixtapes/library/JSONParser$1$1;

    iget-object v3, p0, Lcom/livemixtapes/library/JSONParser$1;->val$context:Landroid/app/Activity;

    invoke-direct {v2, p0, v3}, Lcom/livemixtapes/library/JSONParser$1$1;-><init>(Lcom/livemixtapes/library/JSONParser$1;Landroid/app/Activity;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 130
    const v1, 0x1080027

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 131
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 136
    return-void
.end method
