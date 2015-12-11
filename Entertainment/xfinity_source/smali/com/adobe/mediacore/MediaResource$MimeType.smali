.class public final enum Lcom/adobe/mediacore/MediaResource$MimeType;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaResource;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "MimeType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/MediaResource$MimeType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/MediaResource$MimeType;

.field public static final enum HLS_MIME_TYPE:Lcom/adobe/mediacore/MediaResource$MimeType;


# instance fields
.field private final _value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    const/4 v3, 0x0

    new-instance v0, Lcom/adobe/mediacore/MediaResource$MimeType;

    const-string v1, "HLS_MIME_TYPE"

    const-string v2, "application/x-mpegurl"

    invoke-direct {v0, v1, v3, v2}, Lcom/adobe/mediacore/MediaResource$MimeType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/MediaResource$MimeType;->HLS_MIME_TYPE:Lcom/adobe/mediacore/MediaResource$MimeType;

    const/4 v0, 0x1

    new-array v0, v0, [Lcom/adobe/mediacore/MediaResource$MimeType;

    sget-object v1, Lcom/adobe/mediacore/MediaResource$MimeType;->HLS_MIME_TYPE:Lcom/adobe/mediacore/MediaResource$MimeType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/adobe/mediacore/MediaResource$MimeType;->$VALUES:[Lcom/adobe/mediacore/MediaResource$MimeType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput-object p3, p0, Lcom/adobe/mediacore/MediaResource$MimeType;->_value:Ljava/lang/String;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/MediaResource$MimeType;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/MediaResource$MimeType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaResource$MimeType;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/MediaResource$MimeType;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaResource$MimeType;->$VALUES:[Lcom/adobe/mediacore/MediaResource$MimeType;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/MediaResource$MimeType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/MediaResource$MimeType;

    return-object v0
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaResource$MimeType;->_value:Ljava/lang/String;

    return-object v0
.end method
