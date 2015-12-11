.class public Lcom/amazon/device/ads/Controller$ReflectedParcelable;
.super Ljava/lang/Object;
.source "Controller.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/Controller;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReflectedParcelable"
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/device/ads/Controller$ReflectedParcelable;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    new-instance v0, Lcom/amazon/device/ads/Controller$ReflectedParcelable$1;

    invoke-direct {v0}, Lcom/amazon/device/ads/Controller$ReflectedParcelable$1;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/Controller$ReflectedParcelable;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected constructor <init>(Landroid/os/Parcel;)V
    .locals 14
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    .line 41
    .local v1, "c":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v1}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v5

    .line 43
    .local v5, "fields":[Ljava/lang/reflect/Field;
    move-object v0, v5

    .local v0, "arr$":[Ljava/lang/reflect/Field;
    array-length v7, v0

    .local v7, "len$":I
    const/4 v6, 0x0

    .local v6, "i$":I
    :goto_0
    if-ge v6, v7, :cond_1

    aget-object v4, v0, v6

    .line 48
    .local v4, "f":Ljava/lang/reflect/Field;
    :try_start_0
    invoke-virtual {v4, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 49
    .local v2, "dt":Ljava/lang/Object;
    instance-of v8, v2, Landroid/os/Parcelable$Creator;

    if-nez v8, :cond_0

    .line 50
    const/4 v8, 0x0

    invoke-virtual {p1, v8}, Landroid/os/Parcel;->readValue(Ljava/lang/ClassLoader;)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v4, p0, v8}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1

    .line 43
    .end local v2    # "dt":Ljava/lang/Object;
    :cond_0
    :goto_1
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 52
    :catch_0
    move-exception v3

    .line 54
    .local v3, "e":Ljava/lang/IllegalAccessException;
    # getter for: Lcom/amazon/device/ads/Controller;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/Controller;->access$000()Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "Error: Could not create object from parcel: %s"

    new-array v10, v13, [Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/IllegalAccessException;->getMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v10, v12

    invoke-static {v8, v9, v10}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 56
    .end local v3    # "e":Ljava/lang/IllegalAccessException;
    :catch_1
    move-exception v3

    .line 58
    .local v3, "e":Ljava/lang/IllegalArgumentException;
    # getter for: Lcom/amazon/device/ads/Controller;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/Controller;->access$000()Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "Error: Could not create object from parcel: %s"

    new-array v10, v13, [Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v10, v12

    invoke-static {v8, v9, v10}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 62
    .end local v3    # "e":Ljava/lang/IllegalArgumentException;
    .end local v4    # "f":Ljava/lang/reflect/Field;
    :cond_1
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 67
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 13
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 73
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    .line 74
    .local v1, "c":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v1}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v5

    .line 76
    .local v5, "fields":[Ljava/lang/reflect/Field;
    move-object v0, v5

    .local v0, "arr$":[Ljava/lang/reflect/Field;
    array-length v7, v0

    .local v7, "len$":I
    const/4 v6, 0x0

    .local v6, "i$":I
    :goto_0
    if-ge v6, v7, :cond_1

    aget-object v4, v0, v6

    .line 80
    .local v4, "f":Ljava/lang/reflect/Field;
    :try_start_0
    invoke-virtual {v4, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 81
    .local v2, "dt":Ljava/lang/Object;
    instance-of v8, v2, Landroid/os/Parcelable$Creator;

    if-nez v8, :cond_0

    .line 82
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeValue(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1

    .line 76
    .end local v2    # "dt":Ljava/lang/Object;
    :cond_0
    :goto_1
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 84
    :catch_0
    move-exception v3

    .line 86
    .local v3, "e":Ljava/lang/IllegalAccessException;
    # getter for: Lcom/amazon/device/ads/Controller;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/Controller;->access$000()Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "Error: Could not write to parcel: %s"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-virtual {v3}, Ljava/lang/IllegalAccessException;->getMessage()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v8, v9, v10}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 88
    .end local v3    # "e":Ljava/lang/IllegalAccessException;
    :catch_1
    move-exception v3

    .line 90
    .local v3, "e":Ljava/lang/IllegalArgumentException;
    # getter for: Lcom/amazon/device/ads/Controller;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/Controller;->access$000()Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "Error: Could not write to parcel: %s"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-virtual {v3}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v8, v9, v10}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 93
    .end local v3    # "e":Ljava/lang/IllegalArgumentException;
    .end local v4    # "f":Ljava/lang/reflect/Field;
    :cond_1
    return-void
.end method
