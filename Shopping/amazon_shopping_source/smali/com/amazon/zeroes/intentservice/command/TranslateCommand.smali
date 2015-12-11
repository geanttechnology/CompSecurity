.class public Lcom/amazon/zeroes/intentservice/command/TranslateCommand;
.super Ljava/lang/Object;
.source "TranslateCommand.java"

# interfaces
.implements Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/zeroes/intentservice/command/TranslateCommand$Translator;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<S:",
        "Ljava/lang/Object;",
        "T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/amazon/zeroes/intentservice/command/ZeroesCommand",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final command:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/zeroes/intentservice/command/ZeroesCommand",
            "<TS;>;"
        }
    .end annotation
.end field

.field private final translator:Lcom/amazon/zeroes/intentservice/command/TranslateCommand$Translator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/zeroes/intentservice/command/TranslateCommand$Translator",
            "<TS;TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;Lcom/amazon/zeroes/intentservice/command/TranslateCommand$Translator;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/zeroes/intentservice/command/ZeroesCommand",
            "<TS;>;",
            "Lcom/amazon/zeroes/intentservice/command/TranslateCommand$Translator",
            "<TS;TT;>;)V"
        }
    .end annotation

    .prologue
    .line 25
    .local p0, "this":Lcom/amazon/zeroes/intentservice/command/TranslateCommand;, "Lcom/amazon/zeroes/intentservice/command/TranslateCommand<TS;TT;>;"
    .local p1, "command":Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;, "Lcom/amazon/zeroes/intentservice/command/ZeroesCommand<TS;>;"
    .local p2, "translator":Lcom/amazon/zeroes/intentservice/command/TranslateCommand$Translator;, "Lcom/amazon/zeroes/intentservice/command/TranslateCommand$Translator<TS;TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    if-nez p1, :cond_0

    .line 27
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "command must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 30
    :cond_0
    if-nez p2, :cond_1

    .line 31
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "translator must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 34
    :cond_1
    iput-object p1, p0, Lcom/amazon/zeroes/intentservice/command/TranslateCommand;->command:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    .line 35
    iput-object p2, p0, Lcom/amazon/zeroes/intentservice/command/TranslateCommand;->translator:Lcom/amazon/zeroes/intentservice/command/TranslateCommand$Translator;

    .line 36
    return-void
.end method


# virtual methods
.method public perform()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 43
    .local p0, "this":Lcom/amazon/zeroes/intentservice/command/TranslateCommand;, "Lcom/amazon/zeroes/intentservice/command/TranslateCommand<TS;TT;>;"
    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/command/TranslateCommand;->command:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    invoke-interface {v1}, Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;->perform()Ljava/lang/Object;

    move-result-object v0

    .line 44
    .local v0, "source":Ljava/lang/Object;, "TS;"
    if-nez v0, :cond_0

    .line 45
    const/4 v1, 0x0

    .line 48
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/command/TranslateCommand;->translator:Lcom/amazon/zeroes/intentservice/command/TranslateCommand$Translator;

    invoke-interface {v1, v0}, Lcom/amazon/zeroes/intentservice/command/TranslateCommand$Translator;->translate(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0
.end method
