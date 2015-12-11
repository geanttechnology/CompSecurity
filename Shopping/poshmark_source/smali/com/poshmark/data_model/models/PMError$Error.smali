.class public Lcom/poshmark/data_model/models/PMError$Error;
.super Ljava/lang/Object;
.source "PMError.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/PMError;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Error"
.end annotation


# instance fields
.field public error_type:Ljava/lang/String;

.field final synthetic this$0:Lcom/poshmark/data_model/models/PMError;

.field public user_message:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/PMError;)V
    .locals 0

    .prologue
    .line 6
    iput-object p1, p0, Lcom/poshmark/data_model/models/PMError$Error;->this$0:Lcom/poshmark/data_model/models/PMError;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
