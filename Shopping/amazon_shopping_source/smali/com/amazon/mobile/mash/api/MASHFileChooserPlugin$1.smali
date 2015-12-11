.class Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;
.super Ljava/lang/Object;
.source "MASHFileChooserPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->openFileChooser(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;

.field final synthetic val$capture:Z

.field final synthetic val$duration:I

.field final synthetic val$mimeType:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;Ljava/lang/String;ZI)V
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;

    iput-object p2, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;->val$mimeType:Ljava/lang/String;

    iput-boolean p3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;->val$capture:Z

    iput p4, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;->val$duration:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 93
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;

    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;->val$mimeType:Ljava/lang/String;

    # invokes: Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mimeTypeNotSupported(Ljava/lang/String;)Z
    invoke-static {v2, v3}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->access$000(Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 94
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;

    # getter for: Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;
    invoke-static {v2}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->access$100(Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;)Lorg/apache/cordova/CallbackContext;

    move-result-object v2

    sget-object v3, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->MIME_TYPE_NOT_SUPPORTED:Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 107
    :goto_0
    return-void

    .line 98
    :cond_0
    :try_start_0
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;

    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;->val$mimeType:Ljava/lang/String;

    iget-boolean v4, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;->val$capture:Z

    iget v5, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;->val$duration:I

    # invokes: Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createChooserIntent(Ljava/lang/String;ZI)Landroid/content/Intent;
    invoke-static {v2, v3, v4, v5}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->access$200(Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;Ljava/lang/String;ZI)Landroid/content/Intent;

    move-result-object v0

    .line 99
    .local v0, "chooser":Landroid/content/Intent;
    if-nez v0, :cond_1

    .line 100
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;

    # getter for: Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;
    invoke-static {v2}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->access$100(Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;)Lorg/apache/cordova/CallbackContext;

    move-result-object v2

    sget-object v3, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 104
    .end local v0    # "chooser":Landroid/content/Intent;
    :catch_0
    move-exception v1

    .line 105
    .local v1, "e":Ljava/io/IOException;
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;

    # getter for: Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;
    invoke-static {v2}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->access$100(Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;)Lorg/apache/cordova/CallbackContext;

    move-result-object v2

    sget-object v3, Lcom/amazon/mobile/mash/error/MASHError;->PERMISSION_DENIED:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 103
    .end local v1    # "e":Ljava/io/IOException;
    .restart local v0    # "chooser":Landroid/content/Intent;
    :cond_1
    :try_start_1
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;

    iget v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;->val$duration:I

    # invokes: Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->startActivityForResult(Landroid/content/Intent;I)V
    invoke-static {v2, v0, v3}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->access$300(Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;Landroid/content/Intent;I)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
