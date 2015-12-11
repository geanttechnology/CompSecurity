.class public abstract Lcom/stericson/RootTools/RootTools$Result;
.super Ljava/lang/Object;
.source "RootTools.java"

# interfaces
.implements Lcom/stericson/RootTools/IResult;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/stericson/RootTools/RootTools;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Result"
.end annotation


# instance fields
.field private data:Ljava/io/Serializable;

.field private error:I

.field private process:Ljava/lang/Process;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 990
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 991
    iput-object v0, p0, Lcom/stericson/RootTools/RootTools$Result;->process:Ljava/lang/Process;

    .line 992
    iput-object v0, p0, Lcom/stericson/RootTools/RootTools$Result;->data:Ljava/io/Serializable;

    .line 993
    const/4 v0, 0x0

    iput v0, p0, Lcom/stericson/RootTools/RootTools$Result;->error:I

    .line 990
    return-void
.end method


# virtual methods
.method public getData()Ljava/io/Serializable;
    .locals 1

    .prologue
    .line 1018
    iget-object v0, p0, Lcom/stericson/RootTools/RootTools$Result;->data:Ljava/io/Serializable;

    return-object v0
.end method

.method public getError()I
    .locals 1

    .prologue
    .line 1027
    iget v0, p0, Lcom/stericson/RootTools/RootTools$Result;->error:I

    return v0
.end method

.method public getProcess()Ljava/lang/Process;
    .locals 1

    .prologue
    .line 1009
    iget-object v0, p0, Lcom/stericson/RootTools/RootTools$Result;->process:Ljava/lang/Process;

    return-object v0
.end method

.method public abstract onComplete(I)V
.end method

.method public abstract onFailure(Ljava/lang/Exception;)V
.end method

.method public abstract process(Ljava/lang/String;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation
.end method

.method public abstract processError(Ljava/lang/String;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation
.end method

.method public bridge synthetic setData(Ljava/io/Serializable;)Lcom/stericson/RootTools/IResult;
    .locals 1

    .prologue
    .line 1
    invoke-virtual {p0, p1}, Lcom/stericson/RootTools/RootTools$Result;->setData(Ljava/io/Serializable;)Lcom/stericson/RootTools/RootTools$Result;

    move-result-object v0

    return-object v0
.end method

.method public setData(Ljava/io/Serializable;)Lcom/stericson/RootTools/RootTools$Result;
    .locals 0
    .param p1, "data"    # Ljava/io/Serializable;

    .prologue
    .line 1013
    iput-object p1, p0, Lcom/stericson/RootTools/RootTools$Result;->data:Ljava/io/Serializable;

    .line 1014
    return-object p0
.end method

.method public bridge synthetic setError(I)Lcom/stericson/RootTools/IResult;
    .locals 1

    .prologue
    .line 1
    invoke-virtual {p0, p1}, Lcom/stericson/RootTools/RootTools$Result;->setError(I)Lcom/stericson/RootTools/RootTools$Result;

    move-result-object v0

    return-object v0
.end method

.method public setError(I)Lcom/stericson/RootTools/RootTools$Result;
    .locals 0
    .param p1, "error"    # I

    .prologue
    .line 1022
    iput p1, p0, Lcom/stericson/RootTools/RootTools$Result;->error:I

    .line 1023
    return-object p0
.end method

.method public bridge synthetic setProcess(Ljava/lang/Process;)Lcom/stericson/RootTools/IResult;
    .locals 1

    .prologue
    .line 1
    invoke-virtual {p0, p1}, Lcom/stericson/RootTools/RootTools$Result;->setProcess(Ljava/lang/Process;)Lcom/stericson/RootTools/RootTools$Result;

    move-result-object v0

    return-object v0
.end method

.method public setProcess(Ljava/lang/Process;)Lcom/stericson/RootTools/RootTools$Result;
    .locals 0
    .param p1, "process"    # Ljava/lang/Process;

    .prologue
    .line 1004
    iput-object p1, p0, Lcom/stericson/RootTools/RootTools$Result;->process:Ljava/lang/Process;

    .line 1005
    return-object p0
.end method
