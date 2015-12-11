.class public final enum Lcom/amazon/searchapp/retailsearch/client/SearchMethod;
.super Ljava/lang/Enum;
.source "SearchMethod.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/searchapp/retailsearch/client/SearchMethod;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

.field public static final enum FLOW_BARCODE:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

.field public static final enum FLOW_IMAGEMATCH:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

.field public static final enum FLOW_SUPPBARCODE:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

.field public static final enum SCANIT_BARCODE:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

.field public static final enum TEXT:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

.field public static final enum VOICE:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;


# instance fields
.field private final name:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 13
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    const-string/jumbo v1, "TEXT"

    const-string/jumbo v2, "text"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->TEXT:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    .line 16
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    const-string/jumbo v1, "VOICE"

    const-string/jumbo v2, "voice"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->VOICE:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    .line 19
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    const-string/jumbo v1, "SCANIT_BARCODE"

    const-string/jumbo v2, "scanit_barcode"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->SCANIT_BARCODE:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    .line 22
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    const-string/jumbo v1, "FLOW_BARCODE"

    const-string/jumbo v2, "flow_barcode"

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->FLOW_BARCODE:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    .line 25
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    const-string/jumbo v1, "FLOW_SUPPBARCODE"

    const-string/jumbo v2, "flow_suppbarcode"

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->FLOW_SUPPBARCODE:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    .line 28
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    const-string/jumbo v1, "FLOW_IMAGEMATCH"

    const/4 v2, 0x5

    const-string/jumbo v3, "flow_imagematch"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->FLOW_IMAGEMATCH:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    .line 11
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->TEXT:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->VOICE:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->SCANIT_BARCODE:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->FLOW_BARCODE:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->FLOW_SUPPBARCODE:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->FLOW_IMAGEMATCH:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

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
    .line 36
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 37
    iput-object p3, p0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->name:Ljava/lang/String;

    .line 38
    return-void
.end method

.method public static find(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchMethod;
    .locals 5
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 54
    if-eqz p0, :cond_1

    .line 55
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->values()[Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/searchapp/retailsearch/client/SearchMethod;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 56
    .local v3, "searchMethod":Lcom/amazon/searchapp/retailsearch/client/SearchMethod;
    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 62
    .end local v0    # "arr$":[Lcom/amazon/searchapp/retailsearch/client/SearchMethod;
    .end local v1    # "i$":I
    .end local v2    # "len$":I
    .end local v3    # "searchMethod":Lcom/amazon/searchapp/retailsearch/client/SearchMethod;
    :goto_1
    return-object v3

    .line 55
    .restart local v0    # "arr$":[Lcom/amazon/searchapp/retailsearch/client/SearchMethod;
    .restart local v1    # "i$":I
    .restart local v2    # "len$":I
    .restart local v3    # "searchMethod":Lcom/amazon/searchapp/retailsearch/client/SearchMethod;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 62
    .end local v0    # "arr$":[Lcom/amazon/searchapp/retailsearch/client/SearchMethod;
    .end local v1    # "i$":I
    .end local v2    # "len$":I
    .end local v3    # "searchMethod":Lcom/amazon/searchapp/retailsearch/client/SearchMethod;
    :cond_1
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchMethod;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    return-object v0
.end method

.method public static values()[Lcom/amazon/searchapp/retailsearch/client/SearchMethod;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    invoke-virtual {v0}, [Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->name:Ljava/lang/String;

    return-object v0
.end method
