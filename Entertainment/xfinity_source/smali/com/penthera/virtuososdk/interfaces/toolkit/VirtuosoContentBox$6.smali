.class Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$6;
.super Ljava/lang/Object;
.source "VirtuosoContentBox.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->remove(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;Landroid/content/Context;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private final synthetic val$authority:Ljava/lang/String;

.field private final synthetic val$context:Landroid/content/Context;

.field private final synthetic val$vi:Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$6;->val$context:Landroid/content/Context;

    iput-object p2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$6;->val$vi:Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    iput-object p3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$6;->val$authority:Ljava/lang/String;

    .line 1448
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    .line 1452
    const-string v0, "uuid =?"

    .line 1453
    .local v0, "WHERE_CLAUSE":Ljava/lang/String;
    iget-object v5, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$6;->val$context:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    .line 1455
    .local v4, "resolver":Landroid/content/ContentResolver;
    :try_start_0
    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$8()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "attempting to delete "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$6;->val$vi:Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    invoke-interface {v7}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1456
    const/4 v5, 0x1

    new-array v1, v5, [Ljava/lang/String;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$6;->val$vi:Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    invoke-interface {v6}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v1, v5

    .line 1457
    .local v1, "args":[Ljava/lang/String;
    iget-object v5, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$6;->val$authority:Ljava/lang/String;

    invoke-static {v5}, Lcom/penthera/virtuososdk/database/impl/provider/File$FileColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v4, v5, v0, v1}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v3

    .line 1458
    .local v3, "numDeletions":I
    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$8()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "deleted "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "items from the db."

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1459
    iget-object v5, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$6;->val$vi:Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    invoke-interface {v5}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v5

    const/4 v6, 0x4

    if-ne v5, v6, :cond_0

    .line 1460
    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$8()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "attempting to delete fragments for"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$6;->val$vi:Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    invoke-interface {v7}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1461
    const-string v0, "parentUuid=?"

    .line 1462
    iget-object v5, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$6;->val$authority:Ljava/lang/String;

    invoke-static {v5}, Lcom/penthera/virtuososdk/database/impl/provider/FileFragment$FragmentColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v4, v5, v0, v1}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v3

    .line 1463
    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$8()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "deleted "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "fragments from the db."

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1468
    .end local v1    # "args":[Ljava/lang/String;
    .end local v3    # "numDeletions":I
    :cond_0
    :goto_0
    return-void

    .line 1465
    :catch_0
    move-exception v2

    .line 1466
    .local v2, "e":Ljava/lang/IllegalArgumentException;
    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$8()Ljava/lang/String;

    move-result-object v5

    const-string v6, "remove(): delete issue "

    invoke-static {v5, v6, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
