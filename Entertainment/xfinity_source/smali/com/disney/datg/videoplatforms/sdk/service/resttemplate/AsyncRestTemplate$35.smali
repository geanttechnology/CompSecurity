.class synthetic Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$35;
.super Ljava/lang/Object;
.source "AsyncRestTemplate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$org$springframework$http$HttpMethod:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 78
    invoke-static {}, Lorg/springframework/http/HttpMethod;->values()[Lorg/springframework/http/HttpMethod;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$35;->$SwitchMap$org$springframework$http$HttpMethod:[I

    :try_start_0
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$35;->$SwitchMap$org$springframework$http$HttpMethod:[I

    sget-object v1, Lorg/springframework/http/HttpMethod;->POST:Lorg/springframework/http/HttpMethod;

    invoke-virtual {v1}, Lorg/springframework/http/HttpMethod;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method
