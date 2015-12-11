.class public Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;
.super Ljava/lang/Object;
.source "HeaderGroup.java"

# interfaces
.implements Ljava/io/Serializable;
.implements Ljava/lang/Cloneable;


# instance fields
.field private final headers:Ljava/util/List;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    new-instance v0, Ljava/util/ArrayList;

    const/16 v1, 0x10

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    .line 59
    return-void
.end method


# virtual methods
.method public addHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    .locals 1
    .param p1, "header"    # Lcom/comcast/cim/httpcomponentsandroid/Header;

    .prologue
    .line 75
    if-nez p1, :cond_0

    .line 79
    :goto_0
    return-void

    .line 78
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public clear()V
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 66
    return-void
.end method

.method public clone()Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 290
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    .line 291
    .local v0, "clone":Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;
    iget-object v1, v0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 292
    iget-object v1, v0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 293
    return-object v0
.end method

.method public containsHeader(Ljava/lang/String;)Z
    .locals 3
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 241
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 242
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/Header;

    .line 243
    .local v0, "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 244
    const/4 v2, 0x1

    .line 248
    .end local v0    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :goto_1
    return v2

    .line 241
    .restart local v0    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 248
    .end local v0    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_1
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 2

    .prologue
    .line 228
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    new-array v1, v1, [Lcom/comcast/cim/httpcomponentsandroid/Header;

    invoke-interface {v0, v1}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/cim/httpcomponentsandroid/Header;

    check-cast v0, [Lcom/comcast/cim/httpcomponentsandroid/Header;

    return-object v0
.end method

.method public getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 3
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 193
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 194
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/Header;

    .line 195
    .local v0, "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 199
    .end local v0    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :goto_1
    return-object v0

    .line 193
    .restart local v0    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 199
    .end local v0    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 4
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 172
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 174
    .local v1, "headersFound":Ljava/util/ArrayList;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-ge v2, v3, :cond_1

    .line 175
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/Header;

    .line 176
    .local v0, "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 177
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 174
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 181
    .end local v0    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_1
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v3

    new-array v3, v3, [Lcom/comcast/cim/httpcomponentsandroid/Header;

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Lcom/comcast/cim/httpcomponentsandroid/Header;

    check-cast v3, [Lcom/comcast/cim/httpcomponentsandroid/Header;

    return-object v3
.end method

.method public iterator()Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;
    .locals 3

    .prologue
    .line 259
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicListHeaderIterator;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicListHeaderIterator;-><init>(Ljava/util/List;Ljava/lang/String;)V

    return-object v0
.end method

.method public iterator(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 273
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicListHeaderIterator;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-direct {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicListHeaderIterator;-><init>(Ljava/util/List;Ljava/lang/String;)V

    return-object v0
.end method

.method public removeHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    .locals 1
    .param p1, "header"    # Lcom/comcast/cim/httpcomponentsandroid/Header;

    .prologue
    .line 87
    if-nez p1, :cond_0

    .line 91
    :goto_0
    return-void

    .line 90
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public setHeaders([Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    .locals 3
    .param p1, "headers"    # [Lcom/comcast/cim/httpcomponentsandroid/Header;

    .prologue
    .line 122
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->clear()V

    .line 123
    if-nez p1, :cond_1

    .line 129
    :cond_0
    return-void

    .line 126
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v1, p1

    if-ge v0, v1, :cond_0

    .line 127
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    aget-object v2, p1, v0

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 126
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 297
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public updateHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    .locals 4
    .param p1, "header"    # Lcom/comcast/cim/httpcomponentsandroid/Header;

    .prologue
    .line 101
    if-nez p1, :cond_0

    .line 112
    :goto_0
    return-void

    .line 104
    :cond_0
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_2

    .line 105
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/Header;

    .line 106
    .local v0, "current":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 107
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-interface {v2, v1, p1}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 104
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 111
    .end local v0    # "current":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_2
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->headers:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method
