.class public Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;
.super Ljava/lang/Object;
.source "UrlIntercepterConfigEntry.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;",
        ">;"
    }
.end annotation


# instance fields
.field private mDestination:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

.field private mParameters:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/mobile/mash/interception/ParameterModel;",
            ">;"
        }
    .end annotation
.end field

.field private mPattern:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V
    .locals 0
    .param p1, "destination"    # Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;
    .param p2, "pattern"    # Ljava/lang/String;

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-object p2, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->mPattern:Ljava/lang/String;

    .line 38
    iput-object p1, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->mDestination:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    .line 39
    return-void
.end method


# virtual methods
.method public addUrlPathIndexToParseParameter(Ljava/lang/String;I)Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;
    .locals 2
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "segmentIndex"    # I

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->mParameters:Ljava/util/ArrayList;

    if-nez v0, :cond_0

    .line 75
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->mParameters:Ljava/util/ArrayList;

    .line 77
    :cond_0
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->mParameters:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/ParameterModel;

    invoke-direct {v1, p1, p2}, Lcom/amazon/mobile/mash/interception/ParameterModel;-><init>(Ljava/lang/String;I)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 78
    return-object p0
.end method

.method public compareTo(Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)I
    .locals 7
    .param p1, "another"    # Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    .prologue
    const/4 v4, 0x1

    const/4 v3, -0x1

    .line 116
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->getPattern()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "/"

    invoke-virtual {v5, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 117
    .local v2, "thisSegments":[Ljava/lang/String;
    invoke-virtual {p1}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->getPattern()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "/"

    invoke-virtual {v5, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 119
    .local v1, "otherSegments":[Ljava/lang/String;
    array-length v5, v2

    array-length v6, v1

    if-le v5, v6, :cond_1

    .line 132
    :cond_0
    :goto_0
    return v3

    .line 121
    :cond_1
    array-length v5, v2

    array-length v6, v1

    if-ge v5, v6, :cond_2

    move v3, v4

    .line 122
    goto :goto_0

    .line 125
    :cond_2
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v5, v2

    if-ge v0, v5, :cond_5

    .line 126
    const-string/jumbo v5, "*"

    aget-object v6, v2, v0

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    const-string/jumbo v5, "*"

    aget-object v6, v1, v0

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_3

    move v3, v4

    .line 127
    goto :goto_0

    .line 128
    :cond_3
    const-string/jumbo v5, "*"

    aget-object v6, v2, v0

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_4

    const-string/jumbo v5, "*"

    aget-object v6, v1, v0

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 125
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 132
    :cond_5
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 11
    check-cast p1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->compareTo(Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)I

    move-result v0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v0, 0x0

    .line 142
    instance-of v1, p1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    if-nez v1, :cond_1

    .line 145
    .end local p1    # "o":Ljava/lang/Object;
    :cond_0
    :goto_0
    return v0

    .restart local p1    # "o":Ljava/lang/Object;
    :cond_1
    check-cast p1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    .end local p1    # "o":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->compareTo(Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)I

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method public getDestination()Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->mDestination:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    return-object v0
.end method

.method public getParamList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/mobile/mash/interception/ParameterModel;",
            ">;"
        }
    .end annotation

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->mParameters:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getPattern()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->mPattern:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->mPattern:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    return v0
.end method

.method public matches(Ljava/lang/String;)Z
    .locals 6
    .param p1, "urlPath"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 87
    const-string/jumbo v4, "/"

    invoke-virtual {p1, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 88
    .local v2, "urlComponents":[Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->mPattern:Ljava/lang/String;

    const-string/jumbo v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 90
    .local v1, "patternComponents":[Ljava/lang/String;
    array-length v4, v1

    array-length v5, v2

    if-eq v4, v5, :cond_1

    .line 100
    :cond_0
    :goto_0
    return v3

    .line 95
    :cond_1
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_1
    array-length v4, v2

    if-ge v0, v4, :cond_3

    .line 96
    aget-object v4, v1, v0

    const-string/jumbo v5, "*"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    aget-object v4, v2, v0

    aget-object v5, v1, v0

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 95
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 100
    :cond_3
    const/4 v3, 0x1

    goto :goto_0
.end method
