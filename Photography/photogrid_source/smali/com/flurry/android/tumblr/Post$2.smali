.class synthetic Lcom/flurry/android/tumblr/Post$2;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static final synthetic a:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 60
    invoke-static {}, Lcom/flurry/sdk/dz$a;->values()[Lcom/flurry/sdk/dz$a;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/flurry/android/tumblr/Post$2;->a:[I

    :try_start_0
    sget-object v0, Lcom/flurry/android/tumblr/Post$2;->a:[I

    sget-object v1, Lcom/flurry/sdk/dz$a;->a:Lcom/flurry/sdk/dz$a;

    invoke-virtual {v1}, Lcom/flurry/sdk/dz$a;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_1

    :goto_0
    :try_start_1
    sget-object v0, Lcom/flurry/android/tumblr/Post$2;->a:[I

    sget-object v1, Lcom/flurry/sdk/dz$a;->b:Lcom/flurry/sdk/dz$a;

    invoke-virtual {v1}, Lcom/flurry/sdk/dz$a;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    :goto_1
    return-void

    :catch_0
    move-exception v0

    goto :goto_1

    :catch_1
    move-exception v0

    goto :goto_0
.end method
