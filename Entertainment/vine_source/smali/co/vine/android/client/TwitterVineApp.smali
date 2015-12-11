.class public Lco/vine/android/client/TwitterVineApp;
.super Ljava/lang/Object;
.source "TwitterVineApp.java"


# static fields
.field public static final API_KEY:Ljava/lang/String;

.field public static final API_SECRET:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    invoke-static {}, Lco/vine/android/client/TwitterVineApp;->transform1()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lco/vine/android/client/TwitterVineApp;->API_KEY:Ljava/lang/String;

    .line 13
    invoke-static {}, Lco/vine/android/client/TwitterVineApp;->transform2()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lco/vine/android/client/TwitterVineApp;->API_SECRET:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static transform1()Ljava/lang/String;
    .locals 8

    .prologue
    .line 16
    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v7, 0xa

    if-ge v6, v7, :cond_0

    .line 17
    const-string v6, ""

    .line 27
    .local v0, "arr$":[B
    .local v2, "i$":I
    .local v3, "len$":I
    .local v4, "m":[B
    .local v5, "sb":Ljava/lang/StringBuilder;
    :goto_0
    return-object v6

    .line 19
    .end local v0    # "arr$":[B
    .end local v2    # "i$":I
    .end local v3    # "len$":I
    .end local v4    # "m":[B
    .end local v5    # "sb":Ljava/lang/StringBuilder;
    :cond_0
    const/16 v6, 0x15

    new-array v4, v6, [B

    fill-array-data v4, :array_0

    .line 23
    .restart local v4    # "m":[B
    new-instance v5, Ljava/lang/StringBuilder;

    array-length v6, v4

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 24
    .restart local v5    # "sb":Ljava/lang/StringBuilder;
    move-object v0, v4

    .restart local v0    # "arr$":[B
    array-length v3, v0

    .restart local v3    # "len$":I
    const/4 v2, 0x0

    .restart local v2    # "i$":I
    :goto_1
    if-ge v2, v3, :cond_1

    aget-byte v1, v0, v2

    .line 25
    .local v1, "b":B
    rsub-int/lit8 v6, v1, 0x15

    int-to-char v6, v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 24
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 27
    .end local v1    # "b":B
    :cond_1
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto :goto_0

    .line 19
    nop

    :array_0
    .array-data 1
        -0x4ft
        -0x42t
        -0x42t
        -0x21t
        -0x41t
        -0x23t
        -0x54t
        -0x5et
        -0x61t
        -0x3et
        -0x32t
        -0x3dt
        -0x37t
        -0x1ft
        -0x5ct
        -0x4dt
        -0x30t
        -0x57t
        -0x5dt
        -0x32t
        -0x62t
    .end array-data
.end method

.method public static transform2()Ljava/lang/String;
    .locals 8

    .prologue
    .line 31
    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v7, 0xa

    if-ge v6, v7, :cond_0

    .line 32
    const-string v6, ""

    .line 45
    .local v0, "arr$":[B
    .local v2, "i$":I
    .local v3, "len$":I
    .local v4, "m":[B
    .local v5, "sb":Ljava/lang/StringBuilder;
    :goto_0
    return-object v6

    .line 34
    .end local v0    # "arr$":[B
    .end local v2    # "i$":I
    .end local v3    # "len$":I
    .end local v4    # "m":[B
    .end local v5    # "sb":Ljava/lang/StringBuilder;
    :cond_0
    const/16 v6, 0x2a

    new-array v4, v6, [B

    fill-array-data v4, :array_0

    .line 41
    .restart local v4    # "m":[B
    new-instance v5, Ljava/lang/StringBuilder;

    array-length v6, v4

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 42
    .restart local v5    # "sb":Ljava/lang/StringBuilder;
    move-object v0, v4

    .restart local v0    # "arr$":[B
    array-length v3, v0

    .restart local v3    # "len$":I
    const/4 v2, 0x0

    .restart local v2    # "i$":I
    :goto_1
    if-ge v2, v3, :cond_1

    aget-byte v1, v0, v2

    .line 43
    .local v1, "b":B
    rsub-int/lit8 v6, v1, 0x15

    int-to-char v6, v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 42
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 45
    .end local v1    # "b":B
    :cond_1
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto :goto_0

    .line 34
    nop

    :array_0
    .array-data 1
        -0x20t
        -0x36t
        -0x41t
        -0x22t
        -0x1dt
        -0x1ft
        -0x1bt
        -0x21t
        -0x30t
        -0x32t
        -0x3ft
        -0x3et
        -0x50t
        -0x38t
        -0x5et
        -0x34t
        -0x59t
        -0x5bt
        -0x35t
        -0x1dt
        -0x52t
        -0x33t
        -0x2ft
        -0x2ct
        -0x37t
        -0x1et
        -0x32t
        -0x54t
        -0x33t
        -0x54t
        -0x34t
        -0x3ct
        -0x1ft
        -0x59t
        -0x50t
        -0x4dt
        -0x2dt
        -0x55t
        -0x61t
        -0x4ct
        -0x65t
        -0x5et
    .end array-data
.end method
