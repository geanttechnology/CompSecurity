.class public Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;
.super Ljava/lang/Object;
.source "RemoteControlClientCompat.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/RemoteControlClientCompat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "MetadataEditorCompat"
.end annotation


# static fields
.field public static final METADATA_KEY_ARTWORK:I = 0x64


# instance fields
.field private mActualMetadataEditor:Ljava/lang/Object;

.field private mApplyMethod:Ljava/lang/reflect/Method;

.field private mClearMethod:Ljava/lang/reflect/Method;

.field private mPutBitmapMethod:Ljava/lang/reflect/Method;

.field private mPutLongMethod:Ljava/lang/reflect/Method;

.field private mPutStringMethod:Ljava/lang/reflect/Method;

.field final synthetic this$0:Lcom/livemixtapes/RemoteControlClientCompat;


# direct methods
.method private constructor <init>(Lcom/livemixtapes/RemoteControlClientCompat;Ljava/lang/Object;)V
    .locals 6
    .param p2, "actualMetadataEditor"    # Ljava/lang/Object;

    .prologue
    .line 124
    iput-object p1, p0, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->this$0:Lcom/livemixtapes/RemoteControlClientCompat;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 125
    # getter for: Lcom/livemixtapes/RemoteControlClientCompat;->sHasRemoteControlAPIs:Z
    invoke-static {}, Lcom/livemixtapes/RemoteControlClientCompat;->access$0()Z

    move-result v2

    if-eqz v2, :cond_0

    if-nez p2, :cond_0

    .line 126
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Remote Control API\'s exist, should not be given a null MetadataEditor"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 129
    :cond_0
    # getter for: Lcom/livemixtapes/RemoteControlClientCompat;->sHasRemoteControlAPIs:Z
    invoke-static {}, Lcom/livemixtapes/RemoteControlClientCompat;->access$0()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 130
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    .line 133
    .local v1, "metadataEditorClass":Ljava/lang/Class;
    :try_start_0
    const-string v2, "putString"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Class;

    const/4 v4, 0x0

    .line 134
    sget-object v5, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-class v5, Ljava/lang/String;

    aput-object v5, v3, v4

    .line 133
    invoke-virtual {v1, v2, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    iput-object v2, p0, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->mPutStringMethod:Ljava/lang/reflect/Method;

    .line 135
    const-string v2, "putBitmap"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Class;

    const/4 v4, 0x0

    .line 136
    sget-object v5, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-class v5, Landroid/graphics/Bitmap;

    aput-object v5, v3, v4

    .line 135
    invoke-virtual {v1, v2, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    iput-object v2, p0, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->mPutBitmapMethod:Ljava/lang/reflect/Method;

    .line 137
    const-string v2, "putLong"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Class;

    const/4 v4, 0x0

    .line 138
    sget-object v5, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    sget-object v5, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    aput-object v5, v3, v4

    .line 137
    invoke-virtual {v1, v2, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    iput-object v2, p0, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->mPutLongMethod:Ljava/lang/reflect/Method;

    .line 139
    const-string v2, "clear"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Class;

    invoke-virtual {v1, v2, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    iput-object v2, p0, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->mClearMethod:Ljava/lang/reflect/Method;

    .line 140
    const-string v2, "apply"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Class;

    invoke-virtual {v1, v2, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    iput-object v2, p0, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->mApplyMethod:Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 145
    .end local v1    # "metadataEditorClass":Ljava/lang/Class;
    :cond_1
    iput-object p2, p0, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->mActualMetadataEditor:Ljava/lang/Object;

    .line 146
    return-void

    .line 141
    .restart local v1    # "metadataEditorClass":Ljava/lang/Class;
    :catch_0
    move-exception v0

    .line 142
    .local v0, "e":Ljava/lang/Exception;
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method

.method synthetic constructor <init>(Lcom/livemixtapes/RemoteControlClientCompat;Ljava/lang/Object;Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;)V
    .locals 0

    .prologue
    .line 124
    invoke-direct {p0, p1, p2}, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;-><init>(Lcom/livemixtapes/RemoteControlClientCompat;Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public apply()V
    .locals 4

    .prologue
    .line 248
    # getter for: Lcom/livemixtapes/RemoteControlClientCompat;->sHasRemoteControlAPIs:Z
    invoke-static {}, Lcom/livemixtapes/RemoteControlClientCompat;->access$0()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 250
    :try_start_0
    iget-object v1, p0, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->mApplyMethod:Ljava/lang/reflect/Method;

    iget-object v2, p0, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->mActualMetadataEditor:Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 255
    :cond_0
    return-void

    .line 251
    :catch_0
    move-exception v0

    .line 252
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public clear()V
    .locals 4

    .prologue
    .line 232
    # getter for: Lcom/livemixtapes/RemoteControlClientCompat;->sHasRemoteControlAPIs:Z
    invoke-static {}, Lcom/livemixtapes/RemoteControlClientCompat;->access$0()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 234
    :try_start_0
    iget-object v1, p0, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->mClearMethod:Ljava/lang/reflect/Method;

    iget-object v2, p0, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->mActualMetadataEditor:Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 239
    :cond_0
    return-void

    .line 235
    :catch_0
    move-exception v0

    .line 236
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public putBitmap(ILandroid/graphics/Bitmap;)Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;
    .locals 6
    .param p1, "key"    # I
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 191
    # getter for: Lcom/livemixtapes/RemoteControlClientCompat;->sHasRemoteControlAPIs:Z
    invoke-static {}, Lcom/livemixtapes/RemoteControlClientCompat;->access$0()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 193
    :try_start_0
    iget-object v1, p0, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->mPutBitmapMethod:Ljava/lang/reflect/Method;

    iget-object v2, p0, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->mActualMetadataEditor:Ljava/lang/Object;

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p2, v3, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 198
    :cond_0
    return-object p0

    .line 194
    :catch_0
    move-exception v0

    .line 195
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public putLong(IJ)Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;
    .locals 6
    .param p1, "key"    # I
    .param p2, "value"    # J

    .prologue
    .line 217
    # getter for: Lcom/livemixtapes/RemoteControlClientCompat;->sHasRemoteControlAPIs:Z
    invoke-static {}, Lcom/livemixtapes/RemoteControlClientCompat;->access$0()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 219
    :try_start_0
    iget-object v1, p0, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->mPutLongMethod:Ljava/lang/reflect/Method;

    iget-object v2, p0, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->mActualMetadataEditor:Ljava/lang/Object;

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 224
    :cond_0
    return-object p0

    .line 220
    :catch_0
    move-exception v0

    .line 221
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public putString(ILjava/lang/String;)Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;
    .locals 6
    .param p1, "key"    # I
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 170
    # getter for: Lcom/livemixtapes/RemoteControlClientCompat;->sHasRemoteControlAPIs:Z
    invoke-static {}, Lcom/livemixtapes/RemoteControlClientCompat;->access$0()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 172
    :try_start_0
    iget-object v1, p0, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->mPutStringMethod:Ljava/lang/reflect/Method;

    iget-object v2, p0, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->mActualMetadataEditor:Ljava/lang/Object;

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p2, v3, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 177
    :cond_0
    return-object p0

    .line 173
    :catch_0
    move-exception v0

    .line 174
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method
