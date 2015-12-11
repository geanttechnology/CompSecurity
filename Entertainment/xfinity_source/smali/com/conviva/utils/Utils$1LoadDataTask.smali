.class Lcom/conviva/utils/Utils$1LoadDataTask;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/conviva/utils/Utils;->startFetchClientId()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "LoadDataTask"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/conviva/utils/Utils;


# direct methods
.method constructor <init>(Lcom/conviva/utils/Utils;)V
    .locals 0

    iput-object p1, p0, Lcom/conviva/utils/Utils$1LoadDataTask;->this$0:Lcom/conviva/utils/Utils;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    const/4 v1, 0x0

    # getter for: Lcom/conviva/utils/Utils;->_appContext:Landroid/content/Context;
    invoke-static {}, Lcom/conviva/utils/Utils;->access$000()Landroid/content/Context;

    move-result-object v0

    const-string v2, "conviva.json"

    invoke-virtual {v0, v2}, Landroid/content/Context;->getFileStreamPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_6

    new-instance v2, Ljava/lang/StringBuffer;

    const-string v0, ""

    invoke-direct {v2, v0}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    :try_start_0
    # getter for: Lcom/conviva/utils/Utils;->_appContext:Landroid/content/Context;
    invoke-static {}, Lcom/conviva/utils/Utils;->access$000()Landroid/content/Context;

    move-result-object v0

    const-string v3, "conviva.json"

    invoke-virtual {v0, v3}, Landroid/content/Context;->openFileInput(Ljava/lang/String;)Ljava/io/FileInputStream;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_4
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    const/16 v3, 0x400

    :try_start_1
    new-array v3, v3, [B

    :goto_0
    invoke-virtual {v0, v3}, Ljava/io/FileInputStream;->read([B)I

    move-result v4

    const/4 v5, -0x1

    if-eq v4, v5, :cond_2

    new-instance v5, Ljava/lang/String;

    const/4 v6, 0x0

    invoke-direct {v5, v3, v6, v4}, Ljava/lang/String;-><init>([BII)V

    invoke-virtual {v2, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_0

    :catch_0
    move-exception v2

    :goto_1
    :try_start_2
    iget-object v2, p0, Lcom/conviva/utils/Utils$1LoadDataTask;->this$0:Lcom/conviva/utils/Utils;

    const-string v3, "Failed to load data from persistent storage"

    invoke-virtual {v2, v3}, Lcom/conviva/utils/Utils;->err(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    if-eqz v0, :cond_0

    :try_start_3
    invoke-virtual {v0}, Ljava/io/FileInputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2

    :cond_0
    move-object v0, v1

    :goto_2
    if-eqz v0, :cond_1

    const-string v2, "clId"

    invoke-interface {v0, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    const-string v1, "clId"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    :cond_1
    if-eqz v1, :cond_5

    const-string v0, "0"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_5

    const-string v0, "null"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_5

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_5

    iget-object v0, p0, Lcom/conviva/utils/Utils$1LoadDataTask;->this$0:Lcom/conviva/utils/Utils;

    iput-object v1, v0, Lcom/conviva/utils/Utils;->clientId:Ljava/lang/String;

    iget-object v0, p0, Lcom/conviva/utils/Utils$1LoadDataTask;->this$0:Lcom/conviva/utils/Utils;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Setting the client id to "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " (from local storage)"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/conviva/utils/Utils;->log(Ljava/lang/String;)V

    :goto_3
    return-void

    :cond_2
    :try_start_4
    invoke-virtual {v0}, Ljava/io/FileInputStream;->close()V

    iget-object v3, p0, Lcom/conviva/utils/Utils$1LoadDataTask;->this$0:Lcom/conviva/utils/Utils;

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Lcom/conviva/utils/Utils;->jsonDecode(Ljava/lang/String;)Ljava/util/Map;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    move-result-object v2

    if-eqz v0, :cond_3

    :try_start_5
    invoke-virtual {v0}, Ljava/io/FileInputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1

    :cond_3
    move-object v0, v2

    goto :goto_2

    :catch_1
    move-exception v0

    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    move-object v0, v2

    goto :goto_2

    :catch_2
    move-exception v0

    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    move-object v0, v1

    goto :goto_2

    :catchall_0
    move-exception v0

    :goto_4
    if-eqz v1, :cond_4

    :try_start_6
    invoke-virtual {v1}, Ljava/io/FileInputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_3

    :cond_4
    :goto_5
    throw v0

    :catch_3
    move-exception v1

    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_5

    :cond_5
    iget-object v0, p0, Lcom/conviva/utils/Utils$1LoadDataTask;->this$0:Lcom/conviva/utils/Utils;

    const-string v1, "Failed to load the client id from local storage"

    invoke-virtual {v0, v1}, Lcom/conviva/utils/Utils;->log(Ljava/lang/String;)V

    goto :goto_3

    :catchall_1
    move-exception v1

    move-object v7, v1

    move-object v1, v0

    move-object v0, v7

    goto :goto_4

    :catch_4
    move-exception v0

    move-object v0, v1

    goto/16 :goto_1

    :cond_6
    move-object v0, v1

    goto/16 :goto_2
.end method
