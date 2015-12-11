.class public final enum Lcom/damnhandy/uri/template/UriTemplate$Encoding;
.super Ljava/lang/Enum;
.source "UriTemplate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/damnhandy/uri/template/UriTemplate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Encoding"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/damnhandy/uri/template/UriTemplate$Encoding;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/damnhandy/uri/template/UriTemplate$Encoding;

.field public static final enum U:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

.field public static final enum UF:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

.field public static final enum UR:Lcom/damnhandy/uri/template/UriTemplate$Encoding;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 54
    new-instance v0, Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    const-string v1, "U"

    invoke-direct {v0, v1, v2}, Lcom/damnhandy/uri/template/UriTemplate$Encoding;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->U:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    new-instance v0, Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    const-string v1, "UR"

    invoke-direct {v0, v1, v3}, Lcom/damnhandy/uri/template/UriTemplate$Encoding;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->UR:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    new-instance v0, Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    const-string v1, "UF"

    invoke-direct {v0, v1, v4}, Lcom/damnhandy/uri/template/UriTemplate$Encoding;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->UF:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    .line 53
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    sget-object v1, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->U:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    aput-object v1, v0, v2

    sget-object v1, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->UR:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    aput-object v1, v0, v3

    sget-object v1, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->UF:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    aput-object v1, v0, v4

    sput-object v0, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->$VALUES:[Lcom/damnhandy/uri/template/UriTemplate$Encoding;

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
    .line 53
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/damnhandy/uri/template/UriTemplate$Encoding;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 53
    const-class v0, Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    return-object v0
.end method

.method public static values()[Lcom/damnhandy/uri/template/UriTemplate$Encoding;
    .locals 1

    .prologue
    .line 53
    sget-object v0, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->$VALUES:[Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    invoke-virtual {v0}, [Lcom/damnhandy/uri/template/UriTemplate$Encoding;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    return-object v0
.end method
