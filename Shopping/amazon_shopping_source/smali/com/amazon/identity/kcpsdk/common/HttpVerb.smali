.class public final enum Lcom/amazon/identity/kcpsdk/common/HttpVerb;
.super Ljava/lang/Enum;
.source "HttpVerb.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/kcpsdk/common/HttpVerb;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/kcpsdk/common/HttpVerb;

.field public static final enum HttpVerbConnect:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

.field public static final enum HttpVerbDelete:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

.field public static final enum HttpVerbGet:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

.field public static final enum HttpVerbHead:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

.field public static final enum HttpVerbOptions:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

.field public static final enum HttpVerbPost:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

.field public static final enum HttpVerbPut:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

.field public static final enum HttpVerbTrace:Lcom/amazon/identity/kcpsdk/common/HttpVerb;


# instance fields
.field private final mValue:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 7
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    const-string/jumbo v1, "HttpVerbConnect"

    const-string/jumbo v2, "CONNECT"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/identity/kcpsdk/common/HttpVerb;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbConnect:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    .line 8
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    const-string/jumbo v1, "HttpVerbDelete"

    const-string/jumbo v2, "DELETE"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/identity/kcpsdk/common/HttpVerb;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbDelete:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    .line 9
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    const-string/jumbo v1, "HttpVerbGet"

    const-string/jumbo v2, "GET"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/identity/kcpsdk/common/HttpVerb;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbGet:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    .line 10
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    const-string/jumbo v1, "HttpVerbHead"

    const-string/jumbo v2, "HEAD"

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/identity/kcpsdk/common/HttpVerb;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbHead:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    .line 11
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    const-string/jumbo v1, "HttpVerbOptions"

    const-string/jumbo v2, "OPTIONS"

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/identity/kcpsdk/common/HttpVerb;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbOptions:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    .line 12
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    const-string/jumbo v1, "HttpVerbPost"

    const/4 v2, 0x5

    const-string/jumbo v3, "POST"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/common/HttpVerb;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbPost:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    .line 13
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    const-string/jumbo v1, "HttpVerbPut"

    const/4 v2, 0x6

    const-string/jumbo v3, "PUT"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/common/HttpVerb;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbPut:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    .line 14
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    const-string/jumbo v1, "HttpVerbTrace"

    const/4 v2, 0x7

    const-string/jumbo v3, "TRACE"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/common/HttpVerb;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbTrace:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    .line 5
    const/16 v0, 0x8

    new-array v0, v0, [Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbConnect:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbDelete:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbGet:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbHead:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbOptions:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbPost:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbPut:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbTrace:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->$VALUES:[Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 19
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 20
    iput-object p3, p0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->mValue:Ljava/lang/String;

    .line 21
    return-void
.end method

.method public static parse(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/HttpVerb;
    .locals 5
    .param p0, "value"    # Ljava/lang/String;

    .prologue
    .line 30
    invoke-static {}, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->values()[Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/identity/kcpsdk/common/HttpVerb;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 32
    .local v3, "verb":Lcom/amazon/identity/kcpsdk/common/HttpVerb;
    invoke-virtual {v3}, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 38
    .end local v3    # "verb":Lcom/amazon/identity/kcpsdk/common/HttpVerb;
    :goto_1
    return-object v3

    .line 30
    .restart local v3    # "verb":Lcom/amazon/identity/kcpsdk/common/HttpVerb;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 38
    .end local v3    # "verb":Lcom/amazon/identity/kcpsdk/common/HttpVerb;
    :cond_1
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/HttpVerb;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 5
    const-class v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/kcpsdk/common/HttpVerb;
    .locals 1

    .prologue
    .line 5
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->$VALUES:[Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    invoke-virtual {v0}, [Lcom/amazon/identity/kcpsdk/common/HttpVerb;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    return-object v0
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->mValue:Ljava/lang/String;

    return-object v0
.end method
