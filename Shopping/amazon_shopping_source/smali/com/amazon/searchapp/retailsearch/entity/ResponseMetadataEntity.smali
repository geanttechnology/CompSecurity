.class public Lcom/amazon/searchapp/retailsearch/entity/ResponseMetadataEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "ResponseMetadataEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/ResponseMetadata;


# instance fields
.field private dataVersion:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getDataVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ResponseMetadataEntity;->dataVersion:Ljava/lang/String;

    return-object v0
.end method

.method public setDataVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "dataVersion"    # Ljava/lang/String;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ResponseMetadataEntity;->dataVersion:Ljava/lang/String;

    .line 32
    return-void
.end method
