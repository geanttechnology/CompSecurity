.class public final enum Lcom/comcast/cim/microdata/http/HttpMethod;
.super Ljava/lang/Enum;
.source "HttpMethod.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/cim/microdata/http/HttpMethod;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/cim/microdata/http/HttpMethod;

.field public static final enum DELETE:Lcom/comcast/cim/microdata/http/HttpMethod;

.field public static final enum GET:Lcom/comcast/cim/microdata/http/HttpMethod;

.field public static final enum POST:Lcom/comcast/cim/microdata/http/HttpMethod;

.field public static final enum PUT:Lcom/comcast/cim/microdata/http/HttpMethod;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 4
    new-instance v0, Lcom/comcast/cim/microdata/http/HttpMethod;

    const-string v1, "GET"

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/microdata/http/HttpMethod;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/microdata/http/HttpMethod;->GET:Lcom/comcast/cim/microdata/http/HttpMethod;

    new-instance v0, Lcom/comcast/cim/microdata/http/HttpMethod;

    const-string v1, "POST"

    invoke-direct {v0, v1, v3}, Lcom/comcast/cim/microdata/http/HttpMethod;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/microdata/http/HttpMethod;->POST:Lcom/comcast/cim/microdata/http/HttpMethod;

    new-instance v0, Lcom/comcast/cim/microdata/http/HttpMethod;

    const-string v1, "PUT"

    invoke-direct {v0, v1, v4}, Lcom/comcast/cim/microdata/http/HttpMethod;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/microdata/http/HttpMethod;->PUT:Lcom/comcast/cim/microdata/http/HttpMethod;

    new-instance v0, Lcom/comcast/cim/microdata/http/HttpMethod;

    const-string v1, "DELETE"

    invoke-direct {v0, v1, v5}, Lcom/comcast/cim/microdata/http/HttpMethod;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/microdata/http/HttpMethod;->DELETE:Lcom/comcast/cim/microdata/http/HttpMethod;

    .line 3
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/comcast/cim/microdata/http/HttpMethod;

    sget-object v1, Lcom/comcast/cim/microdata/http/HttpMethod;->GET:Lcom/comcast/cim/microdata/http/HttpMethod;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/cim/microdata/http/HttpMethod;->POST:Lcom/comcast/cim/microdata/http/HttpMethod;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/cim/microdata/http/HttpMethod;->PUT:Lcom/comcast/cim/microdata/http/HttpMethod;

    aput-object v1, v0, v4

    sget-object v1, Lcom/comcast/cim/microdata/http/HttpMethod;->DELETE:Lcom/comcast/cim/microdata/http/HttpMethod;

    aput-object v1, v0, v5

    sput-object v0, Lcom/comcast/cim/microdata/http/HttpMethod;->$VALUES:[Lcom/comcast/cim/microdata/http/HttpMethod;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 3
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/cim/microdata/http/HttpMethod;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 3
    const-class v0, Lcom/comcast/cim/microdata/http/HttpMethod;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/microdata/http/HttpMethod;

    return-object v0
.end method

.method public static values()[Lcom/comcast/cim/microdata/http/HttpMethod;
    .locals 1

    .prologue
    .line 3
    sget-object v0, Lcom/comcast/cim/microdata/http/HttpMethod;->$VALUES:[Lcom/comcast/cim/microdata/http/HttpMethod;

    invoke-virtual {v0}, [Lcom/comcast/cim/microdata/http/HttpMethod;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/cim/microdata/http/HttpMethod;

    return-object v0
.end method
