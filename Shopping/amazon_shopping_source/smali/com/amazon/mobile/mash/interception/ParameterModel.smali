.class Lcom/amazon/mobile/mash/interception/ParameterModel;
.super Ljava/lang/Object;
.source "ParameterModel.java"


# instance fields
.field private mName:Ljava/lang/String;

.field private mPathSegmentIndex:I


# direct methods
.method constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "pathSegmentIndex"    # I

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/amazon/mobile/mash/interception/ParameterModel;->mName:Ljava/lang/String;

    .line 25
    iput p2, p0, Lcom/amazon/mobile/mash/interception/ParameterModel;->mPathSegmentIndex:I

    .line 26
    return-void
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/ParameterModel;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public getPathSegmentIndex()I
    .locals 1

    .prologue
    .line 39
    iget v0, p0, Lcom/amazon/mobile/mash/interception/ParameterModel;->mPathSegmentIndex:I

    return v0
.end method
