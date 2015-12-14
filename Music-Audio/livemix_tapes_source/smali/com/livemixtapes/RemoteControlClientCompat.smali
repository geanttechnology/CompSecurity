.class public Lcom/livemixtapes/RemoteControlClientCompat;
.super Ljava/lang/Object;
.source "RemoteControlClientCompat.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "RemoteControlCompat"

.field private static sHasRemoteControlAPIs:Z

.field private static sRCCEditMetadataMethod:Ljava/lang/reflect/Method;

.field private static sRCCSetPlayStateMethod:Ljava/lang/reflect/Method;

.field private static sRCCSetTransportControlFlags:Ljava/lang/reflect/Method;

.field private static sRemoteControlClientClass:Ljava/lang/Class;


# instance fields
.field private mActualRemoteControlClient:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 11

    .prologue
    const/4 v5, 0x0

    .line 23
    sput-boolean v5, Lcom/livemixtapes/RemoteControlClientCompat;->sHasRemoteControlAPIs:Z

    .line 27
    :try_start_0
    const-class v6, Lcom/livemixtapes/RemoteControlClientCompat;

    invoke-virtual {v6}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    .line 28
    .local v0, "classLoader":Ljava/lang/ClassLoader;
    invoke-static {v0}, Lcom/livemixtapes/RemoteControlClientCompat;->getActualRemoteControlClientClass(Ljava/lang/ClassLoader;)Ljava/lang/Class;

    move-result-object v6

    sput-object v6, Lcom/livemixtapes/RemoteControlClientCompat;->sRemoteControlClientClass:Ljava/lang/Class;

    .line 31
    const-class v6, Lcom/livemixtapes/RemoteControlClientCompat;

    invoke-virtual {v6}, Ljava/lang/Class;->getFields()[Ljava/lang/reflect/Field;

    move-result-object v6

    array-length v7, v6

    :goto_0
    if-lt v5, v7, :cond_0

    .line 48
    sget-object v5, Lcom/livemixtapes/RemoteControlClientCompat;->sRemoteControlClientClass:Ljava/lang/Class;

    const-string v6, "editMetadata"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Class;

    const/4 v8, 0x0

    .line 49
    sget-object v9, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v9, v7, v8

    .line 48
    invoke-virtual {v5, v6, v7}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v5

    sput-object v5, Lcom/livemixtapes/RemoteControlClientCompat;->sRCCEditMetadataMethod:Ljava/lang/reflect/Method;

    .line 50
    sget-object v5, Lcom/livemixtapes/RemoteControlClientCompat;->sRemoteControlClientClass:Ljava/lang/Class;

    const-string v6, "setPlaybackState"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Class;

    const/4 v8, 0x0

    .line 51
    sget-object v9, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v9, v7, v8

    .line 50
    invoke-virtual {v5, v6, v7}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v5

    sput-object v5, Lcom/livemixtapes/RemoteControlClientCompat;->sRCCSetPlayStateMethod:Ljava/lang/reflect/Method;

    .line 52
    sget-object v5, Lcom/livemixtapes/RemoteControlClientCompat;->sRemoteControlClientClass:Ljava/lang/Class;

    .line 53
    const-string v6, "setTransportControlFlags"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Class;

    const/4 v8, 0x0

    sget-object v9, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v9, v7, v8

    .line 52
    invoke-virtual {v5, v6, v7}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v5

    sput-object v5, Lcom/livemixtapes/RemoteControlClientCompat;->sRCCSetTransportControlFlags:Ljava/lang/reflect/Method;

    .line 55
    const/4 v5, 0x1

    sput-boolean v5, Lcom/livemixtapes/RemoteControlClientCompat;->sHasRemoteControlAPIs:Z

    .line 65
    :goto_1
    return-void

    .line 31
    :cond_0
    aget-object v2, v6, v5
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_5
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_6

    .line 33
    .local v2, "field":Ljava/lang/reflect/Field;
    :try_start_1
    sget-object v8, Lcom/livemixtapes/RemoteControlClientCompat;->sRemoteControlClientClass:Ljava/lang/Class;

    invoke-virtual {v2}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/Class;->getField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v3

    .line 34
    .local v3, "realField":Ljava/lang/reflect/Field;
    const/4 v8, 0x0

    invoke-virtual {v3, v8}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 35
    .local v4, "realValue":Ljava/lang/Object;
    const/4 v8, 0x0

    invoke-virtual {v2, v8, v4}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/lang/ClassNotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/NoSuchMethodException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_6

    .line 31
    .end local v3    # "realField":Ljava/lang/reflect/Field;
    .end local v4    # "realValue":Ljava/lang/Object;
    :goto_2
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 36
    :catch_0
    move-exception v1

    .line 37
    .local v1, "e":Ljava/lang/NoSuchFieldException;
    :try_start_2
    const-string v8, "RemoteControlCompat"

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "Could not get real field: "

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2

    .line 56
    .end local v1    # "e":Ljava/lang/NoSuchFieldException;
    .end local v2    # "field":Ljava/lang/reflect/Field;
    :catch_1
    move-exception v5

    goto :goto_1

    .line 38
    .restart local v2    # "field":Ljava/lang/reflect/Field;
    :catch_2
    move-exception v1

    .line 39
    .local v1, "e":Ljava/lang/IllegalArgumentException;
    const-string v8, "RemoteControlCompat"

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "Error trying to pull field value for: "

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    .line 40
    const-string v10, " "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v1}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 39
    invoke-static {v8, v9}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2

    .line 58
    .end local v1    # "e":Ljava/lang/IllegalArgumentException;
    .end local v2    # "field":Ljava/lang/reflect/Field;
    :catch_3
    move-exception v5

    goto :goto_1

    .line 41
    .restart local v2    # "field":Ljava/lang/reflect/Field;
    :catch_4
    move-exception v1

    .line 42
    .local v1, "e":Ljava/lang/IllegalAccessException;
    const-string v8, "RemoteControlCompat"

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "Error trying to pull field value for: "

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    .line 43
    const-string v10, " "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v1}, Ljava/lang/IllegalAccessException;->getMessage()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 42
    invoke-static {v8, v9}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/lang/ClassNotFoundException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/NoSuchMethodException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/lang/IllegalArgumentException; {:try_start_2 .. :try_end_2} :catch_5
    .catch Ljava/lang/SecurityException; {:try_start_2 .. :try_end_2} :catch_6

    goto :goto_2

    .line 60
    .end local v1    # "e":Ljava/lang/IllegalAccessException;
    .end local v2    # "field":Ljava/lang/reflect/Field;
    :catch_5
    move-exception v5

    goto/16 :goto_1

    .line 62
    :catch_6
    move-exception v5

    goto/16 :goto_1
.end method

.method public constructor <init>(Landroid/app/PendingIntent;)V
    .locals 5
    .param p1, "pendingIntent"    # Landroid/app/PendingIntent;

    .prologue
    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 75
    sget-boolean v1, Lcom/livemixtapes/RemoteControlClientCompat;->sHasRemoteControlAPIs:Z

    if-nez v1, :cond_0

    .line 84
    :goto_0
    return-void

    .line 80
    :cond_0
    :try_start_0
    sget-object v1, Lcom/livemixtapes/RemoteControlClientCompat;->sRemoteControlClientClass:Ljava/lang/Class;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Class;

    const/4 v3, 0x0

    const-class v4, Landroid/app/PendingIntent;

    aput-object v4, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 81
    aput-object p1, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 79
    iput-object v1, p0, Lcom/livemixtapes/RemoteControlClientCompat;->mActualRemoteControlClient:Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 82
    :catch_0
    move-exception v0

    .line 83
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public constructor <init>(Landroid/app/PendingIntent;Landroid/os/Looper;)V
    .locals 5
    .param p1, "pendingIntent"    # Landroid/app/PendingIntent;
    .param p2, "looper"    # Landroid/os/Looper;

    .prologue
    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 88
    sget-boolean v1, Lcom/livemixtapes/RemoteControlClientCompat;->sHasRemoteControlAPIs:Z

    if-nez v1, :cond_0

    .line 98
    :goto_0
    return-void

    .line 94
    :cond_0
    :try_start_0
    sget-object v1, Lcom/livemixtapes/RemoteControlClientCompat;->sRemoteControlClientClass:Ljava/lang/Class;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Class;

    const/4 v3, 0x0

    const-class v4, Landroid/app/PendingIntent;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-class v4, Landroid/os/Looper;

    aput-object v4, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v1

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 95
    aput-object p1, v2, v3

    const/4 v3, 0x1

    aput-object p2, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 93
    iput-object v1, p0, Lcom/livemixtapes/RemoteControlClientCompat;->mActualRemoteControlClient:Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 96
    :catch_0
    move-exception v0

    .line 97
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "RemoteControlCompat"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Error creating new instance of "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v3, Lcom/livemixtapes/RemoteControlClientCompat;->sRemoteControlClientClass:Ljava/lang/Class;

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method static synthetic access$0()Z
    .locals 1

    .prologue
    .line 23
    sget-boolean v0, Lcom/livemixtapes/RemoteControlClientCompat;->sHasRemoteControlAPIs:Z

    return v0
.end method

.method public static getActualRemoteControlClientClass(Ljava/lang/ClassLoader;)Ljava/lang/Class;
    .locals 1
    .param p0, "classLoader"    # Ljava/lang/ClassLoader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 69
    const-string v0, "android.media.RemoteControlClient"

    invoke-virtual {p0, v0}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public editMetadata(Z)Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;
    .locals 7
    .param p1, "startEmpty"    # Z

    .prologue
    .line 266
    sget-boolean v2, Lcom/livemixtapes/RemoteControlClientCompat;->sHasRemoteControlAPIs:Z

    if-eqz v2, :cond_0

    .line 268
    :try_start_0
    sget-object v2, Lcom/livemixtapes/RemoteControlClientCompat;->sRCCEditMetadataMethod:Ljava/lang/reflect/Method;

    iget-object v3, p0, Lcom/livemixtapes/RemoteControlClientCompat;->mActualRemoteControlClient:Ljava/lang/Object;

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    .line 269
    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    aput-object v6, v4, v5

    .line 268
    invoke-virtual {v2, v3, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 276
    :goto_0
    new-instance v2, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v1, v3}, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;-><init>(Lcom/livemixtapes/RemoteControlClientCompat;Ljava/lang/Object;Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;)V

    return-object v2

    .line 270
    :catch_0
    move-exception v0

    .line 271
    .local v0, "e":Ljava/lang/Exception;
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2

    .line 274
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_0
    const/4 v1, 0x0

    .local v1, "metadataEditor":Ljava/lang/Object;
    goto :goto_0
.end method

.method public final getActualRemoteControlClientObject()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 326
    iget-object v0, p0, Lcom/livemixtapes/RemoteControlClientCompat;->mActualRemoteControlClient:Ljava/lang/Object;

    return-object v0
.end method

.method public setPlaybackState(I)V
    .locals 6
    .param p1, "state"    # I

    .prologue
    .line 293
    sget-boolean v1, Lcom/livemixtapes/RemoteControlClientCompat;->sHasRemoteControlAPIs:Z

    if-eqz v1, :cond_0

    .line 295
    :try_start_0
    sget-object v1, Lcom/livemixtapes/RemoteControlClientCompat;->sRCCSetPlayStateMethod:Ljava/lang/reflect/Method;

    iget-object v2, p0, Lcom/livemixtapes/RemoteControlClientCompat;->mActualRemoteControlClient:Ljava/lang/Object;

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 300
    :cond_0
    return-void

    .line 296
    :catch_0
    move-exception v0

    .line 297
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public setTransportControlFlags(I)V
    .locals 6
    .param p1, "transportControlFlags"    # I

    .prologue
    .line 315
    sget-boolean v1, Lcom/livemixtapes/RemoteControlClientCompat;->sHasRemoteControlAPIs:Z

    if-eqz v1, :cond_0

    .line 317
    :try_start_0
    sget-object v1, Lcom/livemixtapes/RemoteControlClientCompat;->sRCCSetTransportControlFlags:Ljava/lang/reflect/Method;

    iget-object v2, p0, Lcom/livemixtapes/RemoteControlClientCompat;->mActualRemoteControlClient:Ljava/lang/Object;

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    .line 318
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    .line 317
    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 323
    :cond_0
    return-void

    .line 319
    :catch_0
    move-exception v0

    .line 320
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method
