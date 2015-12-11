.class Lcom/conviva/utils/Utils$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/conviva/utils/CallableWithParameters$With1;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/conviva/utils/Utils;->writeClientId()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/conviva/utils/CallableWithParameters$With1",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/conviva/utils/Utils;


# direct methods
.method constructor <init>(Lcom/conviva/utils/Utils;)V
    .locals 0

    iput-object p1, p0, Lcom/conviva/utils/Utils$1;->this$0:Lcom/conviva/utils/Utils;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic exec(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/conviva/utils/Utils$1;->exec(Ljava/lang/String;)V

    return-void
.end method

.method public exec(Ljava/lang/String;)V
    .locals 5

    const/4 v0, 0x0

    :try_start_0
    # getter for: Lcom/conviva/utils/Utils;->_appContext:Landroid/content/Context;
    invoke-static {}, Lcom/conviva/utils/Utils;->access$000()Landroid/content/Context;

    move-result-object v1

    const-string v2, "conviva.json"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    :try_start_1
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/FileOutputStream;->write([B)V

    invoke-virtual {v0}, Ljava/io/FileOutputStream;->flush()V

    invoke-virtual {v0}, Ljava/io/FileOutputStream;->close()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    if-eqz v0, :cond_0

    :try_start_2
    invoke-virtual {v0}, Ljava/io/FileOutputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    :catch_1
    move-exception v1

    :try_start_3
    iget-object v1, p0, Lcom/conviva/utils/Utils$1;->this$0:Lcom/conviva/utils/Utils;

    const-string v2, "Cannot save data to persistent storage"

    invoke-virtual {v1, v2}, Lcom/conviva/utils/Utils;->log(Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    if-eqz v0, :cond_0

    :try_start_4
    invoke-virtual {v0}, Ljava/io/FileOutputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    goto :goto_0

    :catch_2
    move-exception v0

    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    :catchall_0
    move-exception v1

    move-object v4, v1

    move-object v1, v0

    move-object v0, v4

    :goto_1
    if-eqz v1, :cond_1

    :try_start_5
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    :cond_1
    :goto_2
    throw v0

    :catch_3
    move-exception v1

    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_2

    :catchall_1
    move-exception v1

    move-object v4, v1

    move-object v1, v0

    move-object v0, v4

    goto :goto_1
.end method
