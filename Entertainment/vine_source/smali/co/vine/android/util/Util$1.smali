.class synthetic Lco/vine/android/util/Util$1;
.super Ljava/lang/Object;
.source "Util.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/Util;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$co$vine$android$util$Util$ProfileImageSize:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 1038
    invoke-static {}, Lco/vine/android/util/Util$ProfileImageSize;->values()[Lco/vine/android/util/Util$ProfileImageSize;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lco/vine/android/util/Util$1;->$SwitchMap$co$vine$android$util$Util$ProfileImageSize:[I

    :try_start_0
    sget-object v0, Lco/vine/android/util/Util$1;->$SwitchMap$co$vine$android$util$Util$ProfileImageSize:[I

    sget-object v1, Lco/vine/android/util/Util$ProfileImageSize;->SMALL:Lco/vine/android/util/Util$ProfileImageSize;

    invoke-virtual {v1}, Lco/vine/android/util/Util$ProfileImageSize;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_2

    :goto_0
    :try_start_1
    sget-object v0, Lco/vine/android/util/Util$1;->$SwitchMap$co$vine$android$util$Util$ProfileImageSize:[I

    sget-object v1, Lco/vine/android/util/Util$ProfileImageSize;->MEDIUM:Lco/vine/android/util/Util$ProfileImageSize;

    invoke-virtual {v1}, Lco/vine/android/util/Util$ProfileImageSize;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_1

    :goto_1
    :try_start_2
    sget-object v0, Lco/vine/android/util/Util$1;->$SwitchMap$co$vine$android$util$Util$ProfileImageSize:[I

    sget-object v1, Lco/vine/android/util/Util$ProfileImageSize;->LARGE:Lco/vine/android/util/Util$ProfileImageSize;

    invoke-virtual {v1}, Lco/vine/android/util/Util$ProfileImageSize;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_0

    :goto_2
    return-void

    :catch_0
    move-exception v0

    goto :goto_2

    :catch_1
    move-exception v0

    goto :goto_1

    :catch_2
    move-exception v0

    goto :goto_0
.end method
