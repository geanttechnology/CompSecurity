.class public Lcom/comcast/cim/microdata/model/MicrodataResource;
.super Lcom/comcast/cim/microdata/model/MicrodataItemImpl;
.source "MicrodataResource.java"


# instance fields
.field private canonical:Z


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 8
    invoke-direct {p0, p1}, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;-><init>(Ljava/lang/String;)V

    .line 9
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/microdata/model/MicrodataResource;->canonical:Z

    .line 10
    return-void
.end method


# virtual methods
.method public get(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 16
    invoke-super {p0, p1}, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->get(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    return-object v0
.end method

.method public get(Ljava/lang/String;Z)Lcom/comcast/cim/microdata/model/MicrodataProperty;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "useNetwork"    # Z

    .prologue
    .line 22
    invoke-super {p0, p1}, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->get(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    return-object v0
.end method

.method public isCanonical()Z
    .locals 1

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/comcast/cim/microdata/model/MicrodataResource;->canonical:Z

    return v0
.end method

.method public setCanonical(Z)V
    .locals 0
    .param p1, "canonical"    # Z

    .prologue
    .line 31
    iput-boolean p1, p0, Lcom/comcast/cim/microdata/model/MicrodataResource;->canonical:Z

    .line 32
    return-void
.end method
