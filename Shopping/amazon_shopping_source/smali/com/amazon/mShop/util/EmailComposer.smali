.class public Lcom/amazon/mShop/util/EmailComposer;
.super Ljava/lang/Object;
.source "EmailComposer.java"


# instance fields
.field private mBody:Ljava/lang/String;

.field private mCCAddresses:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final mContext:Landroid/content/Context;

.field private mFileAttachments:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation
.end field

.field private mMIMEType:Ljava/lang/String;

.field private mSubject:Ljava/lang/String;

.field private mToAddresses:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p4, "subject"    # Ljava/lang/String;
    .param p5, "body"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 42
    .local p2, "toAddresses":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .local p3, "ccAddresses":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    iput-object p1, p0, Lcom/amazon/mShop/util/EmailComposer;->mContext:Landroid/content/Context;

    .line 44
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/util/EmailComposer;->mFileAttachments:Ljava/util/List;

    .line 45
    if-eqz p2, :cond_0

    .line 47
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/amazon/mShop/util/EmailComposer;->mToAddresses:Ljava/util/List;

    .line 50
    :cond_0
    if-eqz p3, :cond_1

    .line 52
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/amazon/mShop/util/EmailComposer;->mCCAddresses:Ljava/util/List;

    .line 54
    :cond_1
    iput-object p4, p0, Lcom/amazon/mShop/util/EmailComposer;->mSubject:Ljava/lang/String;

    .line 55
    iput-object p5, p0, Lcom/amazon/mShop/util/EmailComposer;->mBody:Ljava/lang/String;

    .line 56
    const-string/jumbo v0, "message/rfc822"

    iput-object v0, p0, Lcom/amazon/mShop/util/EmailComposer;->mMIMEType:Ljava/lang/String;

    .line 57
    return-void
.end method

.method private createTempFile([BLjava/lang/String;Ljava/lang/String;)Ljava/io/File;
    .locals 7
    .param p1, "content"    # [B
    .param p2, "prefix"    # Ljava/lang/String;
    .param p3, "fileExtension"    # Ljava/lang/String;

    .prologue
    .line 153
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    if-nez p3, :cond_1

    .line 154
    :cond_0
    const/4 v1, 0x0

    .line 178
    :goto_0
    return-object v1

    .line 155
    :cond_1
    const/4 v1, 0x0

    .line 157
    .local v1, "file":Ljava/io/File;
    :try_start_0
    iget-object v5, p0, Lcom/amazon/mShop/util/EmailComposer;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lcom/amazon/mShop/util/AttachmentContentProvider;->getTempFilesPath(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    .line 159
    .local v3, "pathName":Ljava/lang/String;
    new-instance v4, Ljava/io/File;

    invoke-direct {v4, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 161
    .local v4, "theDir":Ljava/io/File;
    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v5

    if-nez v5, :cond_2

    .line 163
    invoke-virtual {v4}, Ljava/io/File;->mkdir()Z

    .line 166
    :cond_2
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {p2, v5, v4}, Ljava/io/File;->createTempFile(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;

    move-result-object v1

    .line 167
    new-instance v2, Ljava/io/FileOutputStream;

    invoke-direct {v2, v1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 168
    .local v2, "fos":Ljava/io/FileOutputStream;
    invoke-virtual {v2, p1}, Ljava/io/FileOutputStream;->write([B)V

    .line 169
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->flush()V

    .line 170
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->close()V

    .line 171
    invoke-virtual {v1}, Ljava/io/File;->deleteOnExit()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 173
    .end local v2    # "fos":Ljava/io/FileOutputStream;
    .end local v3    # "pathName":Ljava/lang/String;
    .end local v4    # "theDir":Ljava/io/File;
    :catch_0
    move-exception v0

    .line 175
    .local v0, "e":Ljava/io/IOException;
    const-string/jumbo v5, "EmailComposer"

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method private getAttachmentUris()Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/os/Parcelable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 139
    const/4 v2, 0x0

    .line 140
    .local v2, "uris":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/os/Parcelable;>;"
    iget-object v3, p0, Lcom/amazon/mShop/util/EmailComposer;->mFileAttachments:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 142
    new-instance v2, Ljava/util/ArrayList;

    .end local v2    # "uris":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/os/Parcelable;>;"
    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 143
    .restart local v2    # "uris":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/os/Parcelable;>;"
    iget-object v3, p0, Lcom/amazon/mShop/util/EmailComposer;->mFileAttachments:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/io/File;

    .line 145
    .local v0, "aFile":Ljava/io/File;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/amazon/mShop/util/EmailComposer;->mContext:Landroid/content/Context;

    invoke-static {v4}, Lcom/amazon/mShop/util/AttachmentContentProvider;->getAttachmentContentProviderAuthority(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 148
    .end local v0    # "aFile":Ljava/io/File;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    return-object v2
.end method


# virtual methods
.method public attachFile([BLjava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "content"    # [B
    .param p2, "prefix"    # Ljava/lang/String;
    .param p3, "fileExtension"    # Ljava/lang/String;

    .prologue
    .line 73
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mShop/util/EmailComposer;->createTempFile([BLjava/lang/String;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    .line 74
    .local v0, "file":Ljava/io/File;
    if-eqz v0, :cond_0

    .line 76
    iget-object v1, p0, Lcom/amazon/mShop/util/EmailComposer;->mFileAttachments:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 78
    :cond_0
    return-void
.end method

.method public composeEmail()V
    .locals 5

    .prologue
    .line 90
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 92
    .local v1, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/amazon/mShop/util/EmailComposer;->mToAddresses:Ljava/util/List;

    if-eqz v2, :cond_0

    .line 94
    const-string/jumbo v3, "android.intent.extra.EMAIL"

    iget-object v2, p0, Lcom/amazon/mShop/util/EmailComposer;->mToAddresses:Ljava/util/List;

    iget-object v4, p0, Lcom/amazon/mShop/util/EmailComposer;->mToAddresses:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    new-array v4, v4, [Ljava/lang/String;

    invoke-interface {v2, v4}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/String;

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 98
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/util/EmailComposer;->mCCAddresses:Ljava/util/List;

    if-eqz v2, :cond_1

    .line 100
    const-string/jumbo v3, "android.intent.extra.CC"

    iget-object v2, p0, Lcom/amazon/mShop/util/EmailComposer;->mCCAddresses:Ljava/util/List;

    iget-object v4, p0, Lcom/amazon/mShop/util/EmailComposer;->mCCAddresses:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    new-array v4, v4, [Ljava/lang/String;

    invoke-interface {v2, v4}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/String;

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 104
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/util/EmailComposer;->mSubject:Ljava/lang/String;

    if-eqz v2, :cond_2

    .line 105
    const-string/jumbo v2, "android.intent.extra.SUBJECT"

    iget-object v3, p0, Lcom/amazon/mShop/util/EmailComposer;->mSubject:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 107
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/util/EmailComposer;->mBody:Ljava/lang/String;

    if-eqz v2, :cond_3

    .line 108
    const-string/jumbo v2, "android.intent.extra.TEXT"

    iget-object v3, p0, Lcom/amazon/mShop/util/EmailComposer;->mBody:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 110
    :cond_3
    invoke-direct {p0}, Lcom/amazon/mShop/util/EmailComposer;->getAttachmentUris()Ljava/util/ArrayList;

    move-result-object v0

    .line 111
    .local v0, "attachmentURIs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/os/Parcelable;>;"
    iget-object v2, p0, Lcom/amazon/mShop/util/EmailComposer;->mMIMEType:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 112
    if-eqz v0, :cond_5

    .line 114
    const/4 v2, 0x1

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-ne v2, v3, :cond_4

    .line 116
    const-string/jumbo v2, "android.intent.action.SEND"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 117
    const-string/jumbo v3, "android.intent.extra.STREAM"

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Parcelable;

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 132
    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/util/EmailComposer;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/amazon/mShop/util/EmailComposer;->mContext:Landroid/content/Context;

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->send_email:I

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 135
    return-void

    .line 121
    :cond_4
    const-string/jumbo v2, "android.intent.action.SEND_MULTIPLE"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 122
    const-string/jumbo v2, "android.intent.extra.STREAM"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putParcelableArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    goto :goto_0

    .line 130
    :cond_5
    const-string/jumbo v2, "android.intent.action.SEND"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0
.end method
