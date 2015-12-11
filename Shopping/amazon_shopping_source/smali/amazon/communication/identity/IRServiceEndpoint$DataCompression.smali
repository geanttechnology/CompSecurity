.class public final enum Lamazon/communication/identity/IRServiceEndpoint$DataCompression;
.super Ljava/lang/Enum;
.source "IRServiceEndpoint.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lamazon/communication/identity/IRServiceEndpoint;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "DataCompression"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lamazon/communication/identity/IRServiceEndpoint$DataCompression;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

.field public static final enum NEEDED:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

.field public static final enum NOT_NEEDED:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;


# instance fields
.field private final mName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 72
    new-instance v0, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    const-string/jumbo v1, "NEEDED"

    const-string/jumbo v2, "needed"

    invoke-direct {v0, v1, v3, v2}, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->NEEDED:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    new-instance v0, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    const-string/jumbo v1, "NOT_NEEDED"

    const-string/jumbo v2, "not-needed"

    invoke-direct {v0, v1, v4, v2}, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->NOT_NEEDED:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    .line 71
    const/4 v0, 0x2

    new-array v0, v0, [Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    sget-object v1, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->NEEDED:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    aput-object v1, v0, v3

    sget-object v1, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->NOT_NEEDED:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    aput-object v1, v0, v4

    sput-object v0, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->$VALUES:[Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 76
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 77
    iput-object p3, p0, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->mName:Ljava/lang/String;

    .line 78
    return-void
.end method

.method public static parse(Ljava/lang/String;)Lamazon/communication/identity/IRServiceEndpoint$DataCompression;
    .locals 4
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 92
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_1

    .line 93
    :cond_0
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "str must not be null or empty"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 96
    :cond_1
    sget-object v0, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->NOT_NEEDED:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    .line 98
    .local v0, "compressionStatus":Lamazon/communication/identity/IRServiceEndpoint$DataCompression;
    sget-object v1, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->NEEDED:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    invoke-virtual {v1}, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 99
    sget-object v0, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->NEEDED:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    .line 106
    :goto_0
    return-object v0

    .line 100
    :cond_2
    sget-object v1, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->NOT_NEEDED:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    invoke-virtual {v1}, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 101
    sget-object v0, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->NOT_NEEDED:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    goto :goto_0

    .line 103
    :cond_3
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "str: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ", cannot be parsed"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public static valueOf(Ljava/lang/String;)Lamazon/communication/identity/IRServiceEndpoint$DataCompression;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 71
    const-class v0, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    return-object v0
.end method

.method public static values()[Lamazon/communication/identity/IRServiceEndpoint$DataCompression;
    .locals 1

    .prologue
    .line 71
    sget-object v0, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->$VALUES:[Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    invoke-virtual {v0}, [Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->mName:Ljava/lang/String;

    return-object v0
.end method
