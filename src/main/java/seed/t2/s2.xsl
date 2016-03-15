<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="fo">
	<xsl:variable name="gdebug" select="0"/>
	
	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simpleA4"
					page-height="29.7cm" page-width="21cm" margin-top="2cm"
					margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
					<fo:region-body />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="simpleA4">
				<fo:flow flow-name="xsl-region-body">
					<fo:block font-size="16pt" font-weight="bold" space-after="5mm">
						Company Name:
						<xsl:value-of select="employees/companyname" />
					</fo:block>
					<fo:block font-size="10pt">
						<fo:table table-layout="fixed" width="100%"
							border-collapse="separate">
							<fo:table-column column-width="4cm" />
							<fo:table-column column-width="4cm" />
							<fo:table-column column-width="5cm" />
							<fo:table-header background-color="darkgrey">
								<fo:table-cell>
					<fo:block>
						xxx
					</fo:block>
				</fo:table-cell>
				<fo:table-cell>
					<fo:block>
						xxx
					</fo:block>
				</fo:table-cell>
				<fo:table-cell>
					<fo:block>
						xxx
					</fo:block>
				</fo:table-cell>
							</fo:table-header>
							<fo:table-body>
								<xsl:if test="$gdebug">
									<xsl:message>##### calling template employee</xsl:message>
								</xsl:if>
								<xsl:call-template name="employee"/>
							</fo:table-body>
						</fo:table>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:include href ="s2i1.xsl" />
</xsl:stylesheet>